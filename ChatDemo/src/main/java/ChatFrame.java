import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ChatFrame extends JFrame {
    InputListener inputListener= null;
    MainPanel mainPanel = new MainPanel();
    public ChatFrame() throws HeadlessException {
        super("欢迎使用聊天机器人");
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }catch(Exception e) {
            System.out.println(e);
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        this.setResizable(false);
        this.add(mainPanel);
        mainPanel.messageInputPannel.submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commitMessage();
            }
        });
        mainPanel.messageInputPannel.input.addKeyListener(
                new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        if((char)e.getKeyChar() == KeyEvent.VK_ENTER) {
                            commitMessage();
                        }
                    }
                }
        );



        this.pack();
        this.setVisible(true);
    }
    public void commitMessage(){
        String message =  mainPanel.messageInputPannel.input.getText().trim();
        if(null == message || message.length() == 0){
            return;
        }
        addMessage(true,message);
        mainPanel.messageInputPannel.input.setText("");
        pack();
        if(null != inputListener){
            new Thread(()->{
                inputListener.message(message);
            }).start();
        }
    }
    public void addMessage(String message){
        addMessage(false,message);

    }
    private void addMessage(boolean send,String message){
        this.mainPanel.messageShowPannel.addMessage(send,message);
        this.pack();
        JScrollBar verticalScrollBar = this.mainPanel.jScrollPane.getVerticalScrollBar();
        verticalScrollBar.setValue(verticalScrollBar.getMaximum());

    }
    public void listen(InputListener listener){
        this.inputListener = listener;
    }
}
interface InputListener{
        void message(String message);
}
class MainPanel extends JPanel{
    MessageShowPanel messageShowPannel = new MessageShowPanel();
    MessageInputPanel messageInputPannel = new MessageInputPanel();
    JScrollPane jScrollPane = new JScrollPane(messageShowPannel);
    public MainPanel() {
        super();
        this.setLayout(new BorderLayout());
        JLabel label=new JLabel("欢迎使用聊天机器人");
        label.setFont(new Font("Dialog",   1,   20));
        JPanel titlePanel = new JPanel(new FlowLayout());
        titlePanel.add(label);
        this.add(titlePanel,BorderLayout.NORTH);

        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPane.setPreferredSize(new Dimension(300,600));
        jScrollPane.setMaximumSize(new Dimension(300,600));
        this.add(jScrollPane,BorderLayout.CENTER);
        this.add(messageInputPannel,BorderLayout.SOUTH);

    }
}
class MessageShowPanel extends JPanel{

    public MessageShowPanel() {
        super();
        this.setBackground(Color.WHITE);
       // LayoutManager layout = new BoxLayout(this,BoxLayout.Y_AXIS);
        LayoutManager layout = new VFlowLayout();
        this.setAutoscrolls(true);
        this.setLayout(layout);

    }
    public void addMessage(boolean send,String message){
        this.add(new MessagePannel(send,message));
    }
}
class MessageInputPanel extends JPanel{
    JTextArea input =new JTextArea(3,30);
    JButton submitBtn = new JButton("提交");
    public MessageInputPanel() {
        super();
        this.setBackground(Color.WHITE);
        this.setLayout(new FlowLayout());

        input.setLineWrap(true);
        input.setFont(new Font("Dialog",   Font.BOLD,   18));

        submitBtn.setPreferredSize(new Dimension(60,55));
        //submitBtn.setBackground(new Color(0xF8F8FF));
        submitBtn.setBorderPainted(false);
        this.add(input);
        this.add(submitBtn);

    }
}
class MessagePannel extends JPanel{
    public MessagePannel(boolean send,String txt) {
       // this.setMinimumSize(new Dimension(400,0));
        this.setBackground(Color.WHITE);
        BoxLayout fl = new BoxLayout(this,BoxLayout.Y_AXIS);
        this.setLayout(fl);

        JLabel descLabel = new JLabel(new SimpleDateFormat("HH:mm:dd").format(new Date()));
        descLabel.setFont(new Font("Dialog",   Font.BOLD,   18));
        descLabel.setForeground(new Color(0xFF2605));
        JLabel contentLabel = new JLabel();
        jLabelSetText(contentLabel,txt,220);
        contentLabel.setFont(new Font("Dialog",   Font.BOLD,   20));


        contentLabel.setVerticalTextPosition(SwingConstants.CENTER);
        JPanel descPanel = new JPanel(new FlowLayout(send?FlowLayout.RIGHT:FlowLayout.LEFT));
        descPanel.setBackground(Color.WHITE);
        JPanel contentPanel = new JPanel(new FlowLayout(send?FlowLayout.RIGHT:FlowLayout.LEFT));
        contentPanel.setBackground(Color.WHITE);
        descPanel.add(descLabel);
        contentPanel.add(contentLabel);
        this.add(descPanel);
        this.add(contentPanel);
    }
    void jLabelSetText(JLabel jLabel, String longString,int maxWidth) {
        StringBuilder builder = new StringBuilder("<html>");
        char[] chars = longString.toCharArray();
        FontMetrics fontMetrics = jLabel.getFontMetrics(jLabel.getFont());
        int start = 0;
        int len = 0;
        while (start + len < longString.length()) {
            while (true) {
                len++;
                if (start + len > longString.length())break;
                if (fontMetrics.charsWidth(chars, start, len)
                        > maxWidth) {
                    break;
                }
            }
            builder.append(chars, start, len-1).append("<br/>");
            start = start + len - 1;
            len = 0;
        }
        builder.append(chars, start, longString.length()-start);
        builder.append("</html>");
        jLabel.setText(builder.toString());
    }

}
class VFlowLayout extends FlowLayout
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Specify alignment top.
     */
    public static final int TOP = 0;

    /**
     * Specify a middle alignment.
     */
    public static final int MIDDLE = 1;

    /**
     * Specify the alignment to be bottom.
     */
    public static final int BOTTOM = 2;

    int hgap;
    int vgap;
    boolean hfill;
    boolean vfill;

    public static void main(String[] args)
    {
        System.out.println("Just for test ...");
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0, 0, 600, 600);
        frame.setLayout(new VFlowLayout());

        int i = 0;
        frame.add(new JButton(String.valueOf(i++)));
        frame.add(new JButton(String.valueOf(i++)));
        frame.add(new JButton(String.valueOf(i++)));
        frame.add(new JButton(String.valueOf(i++)));
        frame.add(new JButton(String.valueOf(i++)));
        frame.add(new JButton(String.valueOf(i++)));
        frame.add(new JButton(String.valueOf(i++)));
        frame.add(new JButton(String.valueOf(i++)));
        frame.add(new JButton(String.valueOf(i++)));
        frame.add(new JButton(String.valueOf(i++)));
        frame.add(new JButton(String.valueOf(i++)));

        frame.setVisible(true);
    }

    /**
     * Construct a new VerticalFlowLayout with a middle alignment, and the fill
     * to edge flag set.
     */
    public VFlowLayout()
    {
        this(TOP, 5, 5, true, false);
    }

    /**
     * Construct a new VerticalFlowLayout with a middle alignment.
     *
     * @param hfill
     *            the fill to edge flag
     * @param vfill
     *            the vertical fill in pixels.
     */
    public VFlowLayout(boolean hfill, boolean vfill)
    {
        this(TOP, 5, 5, hfill, vfill);
    }

    /**
     * Construct a new VerticalFlowLayout with a middle alignment.
     *
     * @param align
     *            the alignment value
     */
    public VFlowLayout(int align)
    {
        this(align, 5, 5, true, false);
    }

    /**
     * Construct a new VerticalFlowLayout.
     *
     * @param align
     *            the alignment value
     * @param hfill
     *            the horizontalfill in pixels.
     * @param vfill
     *            the vertical fill in pixels.
     */
    public VFlowLayout(int align, boolean hfill, boolean vfill)
    {
        this(align, 5, 5, hfill, vfill);
    }

    /**
     * Construct a new VerticalFlowLayout.
     *
     * @param align
     *            the alignment value
     * @param hgap
     *            the horizontal gap variable
     * @param vgap
     *            the vertical gap variable
     * @param hfill
     *            the fill to edge flag
     * @param vfill
     *            true if the panel should vertically fill.
     */
    public VFlowLayout(int align, int hgap, int vgap, boolean hfill, boolean vfill)
    {
        setAlignment(align);
        this.hgap = hgap;
        this.vgap = vgap;
        this.hfill = hfill;
        this.vfill = vfill;
    }

    /**
     * Returns the preferred dimensions given the components in the target
     * container.
     *
     * @param target
     *            the component to lay out
     */
    public Dimension preferredLayoutSize(Container target)
    {
        Dimension tarsiz = new Dimension(0, 0);

        for (int i = 0; i < target.getComponentCount(); i++)
        {
            Component m = target.getComponent(i);

            if (m.isVisible())
            {
                Dimension d = m.getPreferredSize();
                tarsiz.width = Math.max(tarsiz.width, d.width);

                if (i > 0)
                {
                    tarsiz.height += hgap;
                }

                tarsiz.height += d.height;
            }
        }

        Insets insets = target.getInsets();
        tarsiz.width += insets.left + insets.right + hgap * 2;
        tarsiz.height += insets.top + insets.bottom + vgap * 2;

        return tarsiz;
    }

    /**
     * Returns the minimum size needed to layout the target container.
     *
     * @param target
     *            the component to lay out.
     * @return the minimum layout dimension.
     */
    public Dimension minimumLayoutSize(Container target)
    {
        Dimension tarsiz = new Dimension(0, 0);

        for (int i = 0; i < target.getComponentCount(); i++)
        {
            Component m = target.getComponent(i);

            if (m.isVisible())
            {
                Dimension d = m.getMinimumSize();
                tarsiz.width = Math.max(tarsiz.width, d.width);

                if (i > 0)
                {
                    tarsiz.height += vgap;
                }

                tarsiz.height += d.height;
            }
        }

        Insets insets = target.getInsets();
        tarsiz.width += insets.left + insets.right + hgap * 2;
        tarsiz.height += insets.top + insets.bottom + vgap * 2;

        return tarsiz;
    }

    /**
     * Set true to fill vertically.
     *
     * @param vfill
     *            true to fill vertically.
     */
    public void setVerticalFill(boolean vfill)
    {
        this.vfill = vfill;
    }

    /**
     * Returns true if the layout vertically fills.
     *
     * @return true if vertically fills the layout using the specified.
     */
    public boolean getVerticalFill()
    {
        return vfill;
    }

    /**
     * Set to true to enable horizontally fill.
     *
     * @param hfill
     *            true to fill horizontally.
     */
    public void setHorizontalFill(boolean hfill)
    {
        this.hfill = hfill;
    }

    /**
     * Returns true if the layout horizontally fills.
     *
     * @return true if horizontally fills.
     */
    public boolean getHorizontalFill()
    {
        return hfill;
    }

    /**
     * places the components defined by first to last within the target
     * container using the bounds box defined.
     *
     * @param target
     *            the container.
     * @param x
     *            the x coordinate of the area.
     * @param y
     *            the y coordinate of the area.
     * @param width
     *            the width of the area.
     * @param height
     *            the height of the area.
     * @param first
     *            the first component of the container to place.
     * @param last
     *            the last component of the container to place.
     */
    private void placethem(Container target, int x, int y, int width, int height, int first, int last)
    {
        int align = getAlignment();

        if (align == MIDDLE)
        {
            y += height / 2;
        }

        if (align == BOTTOM)
        {
            y += height;
        }

        for (int i = first; i < last; i++)
        {
            Component m = target.getComponent(i);
            Dimension md = m.getSize();

            if (m.isVisible())
            {
                int px = x + (width - md.width) / 2;
                m.setLocation(px, y);
                y += vgap + md.height;
            }
        }
    }

    /**
     * Lays out the container.
     *
     * @param target
     *            the container to lay out.
     */
    public void layoutContainer(Container target)
    {
        Insets insets = target.getInsets();
        int maxheight = target.getSize().height	- (insets.top + insets.bottom + vgap * 2);
        int maxwidth = target.getSize().width - (insets.left + insets.right + hgap * 2);
        int numcomp = target.getComponentCount();
        int x = insets.left + hgap, y = 0;
        int colw = 0, start = 0;

        for (int i = 0; i < numcomp; i++)
        {
            Component m = target.getComponent(i);

            if (m.isVisible())
            {
                Dimension d = m.getPreferredSize();

                // fit last component to remaining height
                if ((this.vfill) && (i == (numcomp - 1)))
                {
                    d.height = Math.max((maxheight - y), m.getPreferredSize().height);
                }

                // fit component size to container width
                if (this.hfill)
                {
                    m.setSize(maxwidth, d.height);
                    d.width = maxwidth;
                }
                else
                {
                    m.setSize(d.width, d.height);
                }

                if (y + d.height > maxheight)
                {
                    placethem(target, x, insets.top + vgap, colw, maxheight - y, start, i);
                    y = d.height;
                    x += hgap + colw;
                    colw = d.width;
                    start = i;
                }
                else
                {
                    if (y > 0)
                    {
                        y += vgap;
                    }

                    y += d.height;
                    colw = Math.max(colw, d.width);
                }
            }
        }

        placethem(target, x, insets.top + vgap, colw, maxheight - y, start,	numcomp);
    }
}
