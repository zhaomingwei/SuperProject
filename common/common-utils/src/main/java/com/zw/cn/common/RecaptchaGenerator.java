package com.zw.cn.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 验证码图片流生成
 *
 * @author ZhaoWei
 * @ClassName RecaptchaUtils
 * @Description
 * @date 2016年6月1日 上午11:25:56
 */
public abstract class RecaptchaGenerator {

    //	    public static final String Redis_KEY = "RECAPTCHA_SESSION_KEY";
    private Random generator = new Random();

    private static char[] captchars = new char[]{'a', 'b', 'c', 'd', 'e',
            '2', '3', '4', '5', '6', '7', '8', 'g', 'y', 'n', 'm', 'p', 'w',
            'x', 'A', 'B', 'D', 'E', 'F', 'G', 'H', 'K', 'M', 'N', 'P', 'R',
            'T', 'Y', 'Z'};

    private Font getFont() {
        Random random = new Random();
        Font font[] = new Font[4];
        font[0] = new Font("Courier", Font.BOLD, (int) (60 + (45 - 60)
                * Math.random()));
        font[1] = new Font("Courier New", Font.BOLD, (int) (60 + (45 - 50)
                * Math.random()));
        font[2] = new Font("Arial", Font.BOLD, (int) (60 + (45 - 60)
                * Math.random()));
        font[3] = new Font("Times New Roman", Font.BOLD, (int) (60 + (45 - 60)
                * Math.random()));
        return font[random.nextInt(4)];
    }

    private Color getRandColor() {
        return new Color((int) (200 + (60 - 200) * Math.random()),
                (int) (200 + (60 - 200) * Math.random()),
                (int) (200 + (60 - 200) * Math.random()));
    }

    /**
     * @param request
     * @param response
     * @return
     * @throws IOException
     * @author ZhaoWei
     * @date 2016年6月1日 下午5:10:24
     */
    public String getRecaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return getRecaptcha(250, 100, 4, request, response);
    }

    /**
     * @param ImageWidth
     * @param ImageHeight
     * @param size
     * @param request
     * @param response
     * @return code
     * @throws IOException
     * @author ZhaoWei
     * @date 2016年6月1日 下午3:53:18
     */
    public String getRecaptcha(int ImageWidth, int ImageHeight, int size, HttpServletRequest request, HttpServletResponse response) throws IOException {

        int car = captchars.length - 1;

        String[] temp = new String[size];
        String code = "";

        for (int i = 0; i < size; i++) {
            temp[i] = "" + captchars[generator.nextInt(car) + 1];
            code += temp[i];
        }

        BufferedImage bi = new BufferedImage(ImageWidth + 10, ImageHeight,
                BufferedImage.TYPE_BYTE_INDEXED);

        Graphics2D graphics = bi.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, bi.getWidth(), bi.getHeight());

        int w = bi.getWidth();
        int h = bi.getHeight();
        for (int i = 0; i < temp.length; i++) {
            graphics.setFont(getFont());
            graphics.setColor(this.getRandColor());
            graphics.drawString(temp[i], i * 45 + (int) (10 * Math.random()),
                    70);
        }

        shear(graphics, w, h, new Color(235, 235, 235));
        makeNoise(bi, .1f, .1f, .25f, .25f);
        makeNoise(bi, .1f, .25f, .5f, .9f);
        responseHandle(request, response, bi, code);
        return code;
    }

    /**
     * @param request
     * @param response
     * @param bi
     * @param code     验证码
     * @throws IOException
     * @author ZhaoWei
     * @date 2016年6月1日 下午5:13:49
     */
    public abstract void responseHandle(HttpServletRequest request, HttpServletResponse response, BufferedImage bi, String code) throws IOException;

    private void shear(Graphics g, int w1, int h1, Color color) {
        shearX(g, w1, h1, color);
        shearY(g, w1, h1, color);
    }

    public void shearX(Graphics g, int w1, int h1, Color color) {

        int period = generator.nextInt(2);
        boolean borderGap = true;
        int frames = 1;
        int phase = generator.nextInt(2);

        for (int i = 0; i < h1; i++) {
            double d = (double) (period >> 1)
                    * Math.sin((double) i / (double) period
                    + (6.2831853071795862D * (double) phase)
                    / (double) frames);
            g.copyArea(0, i, w1, 1, (int) d, 0);
            if (borderGap) {
                g.setColor(color);
                g.drawLine((int) d, i, 0, i);
                g.drawLine((int) d + w1, i, w1, i);
            }
        }
    }

    public void shearY(Graphics g, int w1, int h1, Color color) {

        int period = generator.nextInt(40) + 10; // 50;

        boolean borderGap = true;
        int frames = 20;
        int phase = 7;
        for (int i = 0; i < w1; i++) {
            double d = (double) (period >> 1)
                    * Math.sin((double) i / (double) period
                    + (6.2831853071795862D * (double) phase)
                    / (double) frames);
            g.copyArea(i, 0, 1, h1, 0, (int) d);
            if (borderGap) {
                g.setColor(color);
                g.drawLine(i, (int) d, i, 0);
                g.drawLine(i, (int) d + h1, i, h1);
            }
        }
    }

    public void makeNoise(BufferedImage image, float factorOne,
                          float factorTwo, float factorThree, float factorFour) {
        Color color = getRandColor();

        // image size
        int width = image.getWidth();
        int height = image.getHeight();

        // the points where the line changes the stroke and direction
        Point2D[] pts = null;
        Random rand = new Random();

        // the curve from where the points are taken
        CubicCurve2D cc = new CubicCurve2D.Float(width * factorOne, height
                * rand.nextFloat(), width * factorTwo, height
                * rand.nextFloat(), width * factorThree, height
                * rand.nextFloat(), width * factorFour, height
                * rand.nextFloat());

        // creates an iterator to define the boundary of the flattened curve
        PathIterator pi = cc.getPathIterator(null, 2);
        Point2D tmp[] = new Point2D[200];
        int i = 0;

        // while pi is iterating the curve, adds points to tmp array
        while (!pi.isDone()) {
            float[] coords = new float[6];
            switch (pi.currentSegment(coords)) {
                case PathIterator.SEG_MOVETO:
                case PathIterator.SEG_LINETO:
                    tmp[i] = new Point2D.Float(coords[0], coords[1]);
            }
            i++;
            pi.next();
        }

        pts = new Point2D[i];
        System.arraycopy(tmp, 0, pts, 0, i);

        Graphics2D graph = (Graphics2D) image.getGraphics();
        graph.setRenderingHints(new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON));

        graph.setColor(color);

        // for the maximum 3 point change the stroke and direction
        for (i = 0; i < pts.length - 1; i++) {
            if (i < 3)
                graph.setStroke(new BasicStroke(0.9f * (4 - i)));
            graph.drawLine((int) pts[i].getX(), (int) pts[i].getY(),
                    (int) pts[i + 1].getX(), (int) pts[i + 1].getY());
        }

        graph.dispose();
    }
}
