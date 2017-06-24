package picture.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by admin on 2017/6/24.
 */
public class ThumbnailsTest {

    public static void main(String[] args){
//        File fromFile=new File("C:\\Users\\admin\\Pictures\\Camera Roll\\营业执照.jpg");
        File fromFile=new File("D:\\source\\0624_2.jpg");
        try {
            test1(fromFile);
//            test2(fromFile);
            test3(fromFile);
            test4(fromFile);
            test5(fromFile);
            test6(fromFile);
            test7(fromFile);
            test8(fromFile);

//            Thumbnails.of(fromFile)
//                    .size(160, 160)
//                    .rotate(90)
////                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("watermark.png")), 0.5f)
//                    .outputQuality(0.8f)
//                    .toFile(toFile);

//
//

//
            System.out.println("over");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 按比例缩小
     * */
    private static void test1(File fromFile) throws IOException{
        File toFile=new File("D:\\pic\\按比例缩小.jpg");
        Thumbnails.of(fromFile).scale(0.2f).toFile(toFile);//按比例缩小
    }

    /**
     * 按比例放大
     * */
    private static void test2(File fromFile) throws IOException{
        File toFile=new File("D:\\pic\\按比例放大.jpg");
        Thumbnails.of(fromFile).scale(2f).toFile(toFile);//按比例放大
    }

    /**
     * 按指定大小缩放
     * */
    private static void test3(File fromFile) throws IOException{
        File toFile=new File("D:\\pic\\指定大小缩放.jpg");
        Thumbnails.of(fromFile).size(300,400).keepAspectRatio(false).toFile(toFile);
    }

    /**
     * 压缩
     * */
    private static void test4(File fromFile) throws IOException{
        File toFile=new File("D:\\pic\\压缩.jpg");
        Thumbnails.of(fromFile).scale(1f).outputQuality(0.25f).toFile(toFile);
    }

    /**
     * 旋转图片,根据rotate的数值进行旋转90 ，-90：逆时针旋转
     *
     * */
    private static void test5(File fromFile) throws IOException{
        File toFile=new File("D:\\pic\\顺时针旋转90度.jpg");
        Thumbnails.of(fromFile).scale(1f).outputQuality(0.25f).rotate(90).toFile(toFile);
    }

    /**
     * 水印图片
     *
     * */
    private static void test6(File fromFile) throws IOException{
        File watermark=new File("D:\\source\\1.jpg");
        File toFile=new File("D:\\pic\\加入水印图片.jpg");
        Thumbnails.of(fromFile).scale(1f).watermark(Positions.BOTTOM_RIGHT,ImageIO.read(watermark),0.2f).toFile(toFile);
    }


    /**
     * 裁剪图片
     *
     * */
    private static void test7(File fromFile) throws IOException{
        File toFile=new File("D:\\pic\\裁剪图片.jpg");
        // sourceRegion(Positions.CENTER,400,400):图片中心400*400的区域
        // sourceRegion(Positions.BOTTOM_RIGHT,400,400)  图片底部右边 400*400区域
        // sourceRegion(600,500,400,400) 指定坐标区域
        Thumbnails.of(fromFile).scale(1f).sourceRegion(300,200,400,400).toFile(toFile);
    }

    /**
     *
     *将图片输入到输出流中
     * */
    public static void test8(File fromFile)throws IOException{
        OutputStream os=new FileOutputStream("D:\\pic\\输出流.jpg");
        Thumbnails.of(fromFile)
                .size(1280,1024)
                .toOutputStream(os);

    }

}
