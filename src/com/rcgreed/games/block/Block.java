package com.rcgreed.games.block;

/**
 * block data structure
 * <pre>
 * xxxx 0123
 * 
 * xxx  0124
 * x
 * 
 * xx   0156
 *  xx
 * 
 * xx   0145
 * xx
 * </pre>
 * @author arm
 *
 */

public class Block {
	final static int[] LINE= {0,1,2,3};
	final static int[] LEFT_L= {0,1,2,4};
	final static int[] RIGHT_L= {0,1,2,6};
	final static int[] T = {0,1,2,5};
	final static int[] LEFT_S= {0,1,5,6};
	final static int[] RIGHT_S= {1,2,4,5};
	final static int[] RECT= {0,1,4,5};
	public int[] shape;
	public boolean orientation;
}
