public class Chat {

    public static void main(String[] args) {

        //初始化聊天窗口
        ChatFrame chatFrame = new ChatFrame();

        //欢迎语句
        chatFrame.addMessage("欢迎使用聊天机器人");

        AICloud aiCloud = new AICloud();

        //获取用户输入
        chatFrame.listen(msg ->{
            chatFrame.addMessage(aiCloud.talk(msg ));
        });



    }
}
