package com.sf.openoffice;

import com.artofsolving.jodconverter.DefaultDocumentFormatRegistry;
import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.DocumentFormatRegistry;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;
import com.artofsolving.jodconverter.openoffice.converter.StreamOpenOfficeDocumentConverter;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;

public class RemoteChange {

    public static final String LOCAL_HOST = "127.0.0.1";
    public static final int LOCAL_PORT = 8100;

    // Format
    public static DocumentFormatRegistry formatFactory = new DefaultDocumentFormatRegistry();

    public static void main(String[] args)throws Exception {
        //本地文件，路径英文
        convert("/Users/songfei/Downloads/123.doc","/Users/songfei/Downloads/123.pdf");
    }


    /**
     *
     * @desc
     * @date 2017年6月9日 下午4:11:04
     * @param inputFilePath
     *            待转换的文件路径
     * @param outputFilePath
     *            输出文件路径
     */
    public static void convert(String inputFilePath, String outputFilePath) throws ConnectException {
        convert(inputFilePath, outputFilePath, LOCAL_HOST, LOCAL_PORT);
    }

    /**
     *
     * @desc
     * @date 2017年6月9日 下午4:12:29
     * @param inputFilePath
     *            待转换的文件路径
     * @param outputFilePath
     *            输出文件路径
     * @param connectIp
     *            远程调用ip
     * @param connectPort
     *            远程调用端口
     */
    public static void convert(String inputFilePath, String outputFilePath, String connectIp, int connectPort)
            throws ConnectException {
//        if (StringUtils.isEmpty(inputFilePath) || StringUtils.isEmpty(outputFilePath)
//                || StringUtils.isEmpty(connectIp)) {
//            throw new IllegalArgumentException("参数异常！！");
//        }
        OpenOfficeConnection connection = new SocketOpenOfficeConnection(connectIp, connectPort);
        connection.connect();

        DocumentConverter converter = getConverter(connectIp, connection);

        converter.convert(new File(inputFilePath), new File(outputFilePath));
        connection.disconnect();
    }

    /**
     *
     * @desc
     * @date 2017年6月9日 下午4:08:26
     * @param inputStream
     * @param inputFileExtension
     *            待转换文件的扩展名，例如: xls，doc
     * @param outputStream
     * @param outputFileExtension
     *            输出文件扩展名，例如：pdf
     */
    public static void convert(InputStream inputStream, String inputFileExtension, OutputStream outputStream,
                               String outputFileExtension) throws ConnectException {
        convert(inputStream, inputFileExtension, outputStream, outputFileExtension, LOCAL_HOST, LOCAL_PORT);
    }

    /**
     *
     * @desc
     * @date 2017年6月9日 下午4:10:21
     * @param inputStream
     * @param inputFileExtension
     *            待转换文件的扩展名，例如: xls，doc
     * @param outputStream
     * @param outputFileExtension
     *            输出文件扩展名，例如：pdf
     * @param connectIp
     *            远程调用ip
     * @param connectPort
     *            远程调用端口
     */
    public static void convert(InputStream inputStream, String inputFileExtension, OutputStream outputStream,
                               String outputFileExtension, String connectIp, int connectPort) throws ConnectException {

//        if (inputStream == null || StringUtils.isEmpty(inputFileExtension) || outputStream == null
//                || StringUtils.isEmpty(outputFileExtension) || StringUtils.isEmpty(connectIp)) {
//            throw new IllegalArgumentException("参数异常！！");
//        }

        OpenOfficeConnection connection = new SocketOpenOfficeConnection(connectIp, connectPort);
        connection.connect();
        DocumentConverter converter = getConverter(connectIp, connection);

        converter.convert(inputStream, formatFactory.getFormatByFileExtension(inputFileExtension), outputStream,
                formatFactory.getFormatByFileExtension(outputFileExtension));
        connection.disconnect();
    }

    private static DocumentConverter getConverter(String connectIp, OpenOfficeConnection connection) {
        DocumentConverter converter = "localhost".equals(connectIp) || "127.0.0.1".equals(connectIp)
                || "0:0:0:0:0:0:0:1".equals(connectIp) ? new OpenOfficeDocumentConverter(connection)
                : new StreamOpenOfficeDocumentConverter(connection);
        return converter;
    }
}
