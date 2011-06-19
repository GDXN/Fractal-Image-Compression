package lib.comparators;

import lib.utils.PixelUtils;

import java.awt.image.BufferedImage;

/**
 * different metrics to count the distance of two integers representing pixels
 *
 * @see #distance(int, int)
 * @see PixelUtils
 * @see BufferedImage#getRGB(int, int)
 * @see BufferedImage#getRGB(int, int, int, int, int[], int, int)
 */
public enum Metric {

    /**
     * absolute error count, number of different pixels (-fuzz effected) <br />
     * Return 1 if pixels differ, 0 if there is no difference
     */
    AE {

        @Override
        public double distance(int a, int b) {
            return (a == b) ? 0 : 1;
        }
    },

    /**
     * mean color distance
     */
    FUZZ {

        @Override
        public double distance(int a, int b) {
            return 0;
        }
    },

    /**
     * mean absolute error (normalized), average channel error distance
     */
    MAE {

        @Override
        public double distance(int a, int b) {
            return 0;
        }
    },

    /**
     * mean error per pixel (normalized mean error, normalized peak error)
     */
    MEPP {

        @Override
        public double distance(int a, int b) {
            return 0;
        }
    },

    /**
     * mean error squared, average of the channel error squared <br />
     * {@code MSE = x^2 + y^2 + ... + z^2;}
     */
    MSE {

        @Override
        public double distance(int a, int b) {
            int reddiff   = PixelUtils.getRed  (a) - PixelUtils.getRed  (b);
            int greendiff = PixelUtils.getGreen(a) - PixelUtils.getGreen(b);
            int bluediff  = PixelUtils.getBlue (a) - PixelUtils.getBlue (b);

            return reddiff * reddiff + greendiff * greendiff + bluediff * bluediff;
        }
    },

    /**
     * normalized cross correlation
     */
    NCC {

        @Override
        public double distance(int a, int b) {
            return 0;
        }
    },

    /**
     * peak absolute (normalize peak absolute)
     */
    PAE {

        @Override
        public double distance(int a, int b) {
            return 0;
        }
    },

    /**
     * peak signal to noise ratio
     */
    PSNR {

        @Override
        public double distance(int a, int b) {
            return 0;
        }
    },

    /**
     * root mean squared (normalized root mean squared). <br/>
     * {@code RMSE = Sqrt( x^2 + y^2 + ... + z^2 );}
     */
    RMSE {

        @Override
        public double distance(int a, int b) {
            return Math.sqrt(MSE.distance(a, b));
        }
    },;

    /**
     * TODO: implement other metrics # all those returning 0
     *
     * @param a a pixel to compare to
     * @param b a pixel to compare with
     * @return the distance between the two integers as defined by the metric
     *
     * @see Metric
     * @see PixelUtils
     */
    public double distance(int a, int b) {
        return Math.abs(a - b);
    }
}
