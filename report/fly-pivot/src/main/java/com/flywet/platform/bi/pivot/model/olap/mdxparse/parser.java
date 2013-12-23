package com.flywet.platform.bi.pivot.model.olap.mdxparse;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import java_cup.runtime.Symbol;

/**
 * CUP v0.10k generated parser.
 * 
 * @version Thu Feb 03 16:03:33 EST 2005
 */
public class parser extends java_cup.runtime.lr_parser {

	/** Default constructor. */
	public parser() {
		super();
	}

	/** Constructor which sets the default scanner. */
	public parser(java_cup.runtime.Scanner s) {
		super(s);
	}

	/** Production table. */
	protected static final short _production_table[][] = unpackFromStrings(new String[] { "\000\135\000\002\002\004\000\002\003\011\000\002\011"
			+ "\003\000\002\011\004\000\002\010\002\000\002\010\004"
			+ "\000\002\016\002\000\002\016\003\000\002\017\003\000"
			+ "\002\017\005\000\002\020\007\000\002\051\002\000\002"
			+ "\051\005\000\002\052\003\000\002\052\005\000\002\036"
			+ "\002\000\002\036\004\000\002\040\003\000\002\004\003"
			+ "\000\002\005\002\000\002\005\004\000\002\006\002\000"
			+ "\002\006\005\000\002\007\003\000\002\053\002\000\002"
			+ "\007\006\000\002\012\003\000\002\012\004\000\002\013"
			+ "\003\000\002\013\003\000\002\014\011\000\002\014\007"
			+ "\000\002\041\002\000\002\041\004\000\002\042\003\000"
			+ "\002\042\005\000\002\046\005\000\002\015\010\000\002"
			+ "\015\006\000\002\047\003\000\002\047\005\000\002\037"
			+ "\003\000\002\037\003\000\002\021\005\000\002\021\003"
			+ "\000\002\043\002\000\002\043\003\000\002\044\003\000"
			+ "\002\044\005\000\002\022\003\000\002\022\005\000\002"
			+ "\022\005\000\002\026\003\000\002\026\005\000\002\027"
			+ "\003\000\002\027\004\000\002\030\003\000\002\030\005"
			+ "\000\002\031\003\000\002\031\005\000\002\031\005\000"
			+ "\002\031\005\000\002\032\003\000\002\032\005\000\002"
			+ "\032\005\000\002\033\003\000\002\033\004\000\002\033"
			+ "\004\000\002\025\003\000\002\025\003\000\002\025\003"
			+ "\000\002\025\005\000\002\025\005\000\002\025\005\000"
			+ "\002\025\010\000\002\025\006\000\002\025\005\000\002"
			+ "\025\005\000\002\025\003\000\002\024\007\000\002\023"
			+ "\002\000\002\023\003\000\002\045\002\000\002\045\004"
			+ "\000\002\035\006\000\002\034\002\000\002\034\004\000"
			+ "\002\050\003\000\002\050\003\000\002\050\003\000\002"
			+ "\050\003\000\002\050\003\000\002\050\003" });

	/** Access to production table. */
	public short[][] production_table() {
		return _production_table;
	}

	/** Parse-action table. */
	protected static final short[][] _action_table = unpackFromStrings(new String[] { "\000\232\000\010\012\ufffd\026\ufffd\034\006\001\002\000"
			+ "\004\002\234\001\002\000\006\012\167\026\171\001\002"
			+ "\000\006\017\014\027\013\001\002\000\012\012\uffe5\017"
			+ "\uffe5\026\uffe5\027\uffe5\001\002\000\012\012\uffe7\017\014"
			+ "\026\uffe7\027\013\001\002\000\006\012\ufffc\026\ufffc\001"
			+ "\002\000\012\012\uffe4\017\uffe4\026\uffe4\027\uffe4\001\002"
			+ "\000\006\060\015\061\017\001\002\000\006\060\015\061"
			+ "\017\001\002\000\112\002\uffd8\004\uffd8\005\uffd8\007\uffd8"
			+ "\011\uffd8\012\uffd8\013\uffd8\015\uffd8\016\uffd8\017\uffd8\022"
			+ "\uffd8\023\uffd8\025\uffd8\026\uffd8\027\uffd8\030\uffd8\031\uffd8"
			+ "\032\uffd8\033\uffd8\035\uffd8\036\uffd8\037\uffd8\040\uffd8\041"
			+ "\uffd8\042\uffd8\043\uffd8\044\uffd8\046\uffd8\047\uffd8\050\uffd8"
			+ "\051\uffd8\052\uffd8\053\uffd8\054\uffd8\055\uffd8\056\uffd8\001"
			+ "\002\000\012\005\uffda\022\uffda\037\uffda\041\uffda\001\002"
			+ "\000\112\002\uffd7\004\uffd7\005\uffd7\007\uffd7\011\uffd7\012"
			+ "\uffd7\013\uffd7\015\uffd7\016\uffd7\017\uffd7\022\uffd7\023\uffd7"
			+ "\025\uffd7\026\uffd7\027\uffd7\030\uffd7\031\uffd7\032\uffd7\033"
			+ "\uffd7\035\uffd7\036\uffd7\037\uffd7\040\uffd7\041\uffd7\042\uffd7"
			+ "\043\uffd7\044\uffd7\046\uffd7\047\uffd7\050\uffd7\051\uffd7\052"
			+ "\uffd7\053\uffd7\054\uffd7\055\uffd7\056\uffd7\001\002\000\006"
			+ "\005\021\041\022\001\002\000\030\006\044\021\027\025"
			+ "\032\045\031\047\030\051\043\053\024\057\034\060\015"
			+ "\061\017\063\033\001\002\000\006\060\015\061\017\001"
			+ "\002\000\012\005\uffd9\022\uffd9\037\uffd9\041\uffd9\001\002"
			+ "\000\020\006\044\045\031\047\030\057\034\060\015\061"
			+ "\017\063\033\001\002\000\104\002\uffbb\004\uffbb\007\uffbb"
			+ "\011\uffbb\012\uffbb\013\uffbb\015\uffbb\017\uffbb\022\uffbb\023"
			+ "\uffbb\025\uffbb\026\uffbb\027\uffbb\030\uffbb\031\uffbb\033\uffbb"
			+ "\035\uffbb\036\uffbb\037\uffbb\040\uffbb\041\uffbb\042\uffbb\043"
			+ "\uffbb\044\uffbb\046\uffbb\047\154\050\uffbb\051\uffbb\052\uffbb"
			+ "\053\uffbb\054\uffbb\055\uffbb\056\uffbb\001\002\000\102\002"
			+ "\uffb3\004\uffb3\007\uffb3\011\uffb3\012\uffb3\013\uffb3\015\uffb3"
			+ "\017\uffb3\022\uffb3\023\uffb3\025\uffb3\026\uffb3\027\uffb3\030"
			+ "\uffb3\031\uffb3\033\uffb3\035\uffb3\036\uffb3\037\uffb3\040\uffb3"
			+ "\041\uffb3\042\uffb3\043\uffb3\044\uffb3\046\uffb3\050\uffb3\051"
			+ "\uffb3\052\uffb3\053\uffb3\054\uffb3\055\uffb3\056\uffb3\001\002"
			+ "\000\026\006\044\021\027\045\031\047\030\051\043\053"
			+ "\024\057\034\060\015\061\017\063\033\001\002\000\026"
			+ "\006\044\021\027\045\031\047\030\051\043\053\024\057"
			+ "\034\060\015\061\017\063\033\001\002\000\030\006\044"
			+ "\021\027\045\031\047\030\051\043\053\024\054\uffd4\057"
			+ "\034\060\015\061\017\063\033\001\002\000\026\006\044"
			+ "\021\027\045\031\047\030\051\043\053\024\057\034\060"
			+ "\015\061\017\063\033\001\002\000\102\002\uffbd\004\uffbd"
			+ "\007\uffbd\011\uffbd\012\uffbd\013\uffbd\015\uffbd\017\uffbd\022"
			+ "\uffbd\023\uffbd\025\uffbd\026\uffbd\027\uffbd\030\uffbd\031\uffbd"
			+ "\033\uffbd\035\uffbd\036\uffbd\037\uffbd\040\uffbd\041\uffbd\042"
			+ "\uffbd\043\uffbd\044\uffbd\046\uffbd\050\uffbd\051\uffbd\052\uffbd"
			+ "\053\uffbd\054\uffbd\055\uffbd\056\uffbd\001\002\000\102\002"
			+ "\uffbc\004\uffbc\007\uffbc\011\uffbc\012\uffbc\013\uffbc\015\uffbc"
			+ "\017\uffbc\022\uffbc\023\uffbc\025\uffbc\026\uffbc\027\uffbc\030"
			+ "\uffbc\031\uffbc\033\uffbc\035\uffbc\036\uffbc\037\uffbc\040\uffbc"
			+ "\041\uffbc\042\uffbc\043\uffbc\044\uffbc\046\uffbc\050\uffbc\051"
			+ "\uffbc\052\uffbc\053\uffbc\054\uffbc\055\uffbc\056\uffbc\001\002"
			+ "\000\020\012\uffe1\017\uffe1\023\061\026\uffe1\027\uffe1\033"
			+ "\062\037\133\001\002\000\100\002\uffc3\004\uffc3\007\uffc3"
			+ "\011\uffc3\012\uffc3\013\uffc3\015\uffc3\017\uffc3\022\uffc3\023"
			+ "\uffc3\025\uffc3\026\uffc3\027\uffc3\030\uffc3\031\uffc3\033\uffc3"
			+ "\035\uffc3\036\uffc3\037\uffc3\040\uffc3\042\uffc3\043\uffc3\044"
			+ "\uffc3\046\uffc3\050\uffc3\051\uffc3\052\uffc3\053\uffc3\054\uffc3"
			+ "\055\uffc3\056\uffc3\001\002\000\100\002\uffc7\004\uffc7\007"
			+ "\uffc7\011\uffc7\012\uffc7\013\uffc7\015\uffc7\017\uffc7\022\uffc7"
			+ "\023\uffc7\025\uffc7\026\uffc7\027\uffc7\030\uffc7\031\uffc7\033"
			+ "\uffc7\035\100\036\uffc7\037\uffc7\040\uffc7\042\uffc7\043\uffc7"
			+ "\044\uffc7\046\uffc7\050\uffc7\051\uffc7\052\uffc7\053\uffc7\054"
			+ "\uffc7\055\uffc7\056\101\001\002\000\052\002\uffd0\004\064"
			+ "\007\uffd0\011\uffd0\012\uffd0\013\uffd0\015\uffd0\017\uffd0\022"
			+ "\uffd0\023\uffd0\025\uffd0\026\uffd0\027\uffd0\030\uffd0\031\uffd0"
			+ "\033\uffd0\036\uffd0\037\uffd0\054\uffd0\055\uffd0\001\002\000"
			+ "\052\002\uffcd\004\uffcd\007\uffcd\011\uffcd\012\uffcd\013\uffcd"
			+ "\015\uffcd\017\uffcd\022\uffcd\023\uffcd\025\uffcd\026\uffcd\027"
			+ "\uffcd\030\uffcd\031\uffcd\033\uffcd\036\uffcd\037\uffcd\054\uffcd"
			+ "\055\uffcd\001\002\000\066\002\uffcb\004\uffcb\007\uffcb\011"
			+ "\uffcb\012\uffcb\013\uffcb\015\uffcb\017\uffcb\022\uffcb\023\uffcb"
			+ "\025\uffcb\026\uffcb\027\uffcb\030\uffcb\031\uffcb\033\uffcb\036"
			+ "\uffcb\037\uffcb\042\124\043\127\044\125\046\126\050\123"
			+ "\052\130\054\uffcb\055\uffcb\001\002\000\020\006\044\045"
			+ "\031\047\030\057\034\060\015\061\017\063\033\001\002"
			+ "\000\034\006\044\013\uffb1\015\uffb1\021\027\031\uffb1\045"
			+ "\031\047\030\051\043\053\024\057\034\060\015\061\017"
			+ "\063\033\001\002\000\074\002\uffc9\004\uffc9\007\uffc9\011"
			+ "\uffc9\012\uffc9\013\uffc9\015\uffc9\017\uffc9\022\uffc9\023\uffc9"
			+ "\025\uffc9\026\uffc9\027\uffc9\030\uffc9\031\uffc9\033\uffc9\036"
			+ "\uffc9\037\uffc9\040\075\042\uffc9\043\uffc9\044\uffc9\046\uffc9"
			+ "\050\uffc9\051\076\052\uffc9\053\074\054\uffc9\055\uffc9\001"
			+ "\002\000\102\002\uffc0\004\uffc0\007\uffc0\011\uffc0\012\uffc0"
			+ "\013\uffc0\015\uffc0\017\uffc0\022\uffc0\023\uffc0\025\uffc0\026"
			+ "\uffc0\027\uffc0\030\uffc0\031\uffc0\033\uffc0\035\uffc0\036\uffc0"
			+ "\037\uffc0\040\uffc0\041\047\042\uffc0\043\uffc0\044\uffc0\046"
			+ "\uffc0\050\uffc0\051\uffc0\052\uffc0\053\uffc0\054\uffc0\055\uffc0"
			+ "\056\uffc0\001\002\000\010\060\050\061\053\062\051\001"
			+ "\002\000\104\002\uffba\004\uffba\007\uffba\011\uffba\012\uffba"
			+ "\013\uffba\015\uffba\017\uffba\022\uffba\023\uffba\025\uffba\026"
			+ "\uffba\027\uffba\030\uffba\031\uffba\033\uffba\035\uffba\036\uffba"
			+ "\037\uffba\040\uffba\041\uffba\042\uffba\043\uffba\044\uffba\046"
			+ "\uffba\047\uffd8\050\uffba\051\uffba\052\uffba\053\uffba\054\uffba"
			+ "\055\uffba\056\uffba\001\002\000\102\002\uffb8\004\uffb8\007"
			+ "\uffb8\011\uffb8\012\uffb8\013\uffb8\015\uffb8\017\uffb8\022\uffb8"
			+ "\023\uffb8\025\uffb8\026\uffb8\027\uffb8\030\uffb8\031\uffb8\033"
			+ "\uffb8\035\uffb8\036\uffb8\037\uffb8\040\uffb8\041\uffb8\042\uffb8"
			+ "\043\uffb8\044\uffb8\046\uffb8\050\uffb8\051\uffb8\052\uffb8\053"
			+ "\uffb8\054\uffb8\055\uffb8\056\uffb8\001\002\000\004\047\054"
			+ "\001\002\000\104\002\uffb9\004\uffb9\007\uffb9\011\uffb9\012"
			+ "\uffb9\013\uffb9\015\uffb9\017\uffb9\022\uffb9\023\uffb9\025\uffb9"
			+ "\026\uffb9\027\uffb9\030\uffb9\031\uffb9\033\uffb9\035\uffb9\036"
			+ "\uffb9\037\uffb9\040\uffb9\041\uffb9\042\uffb9\043\uffb9\044\uffb9"
			+ "\046\uffb9\047\uffd7\050\uffb9\051\uffb9\052\uffb9\053\uffb9\054"
			+ "\uffb9\055\uffb9\056\uffb9\001\002\000\030\006\044\021\027"
			+ "\045\031\047\030\051\043\053\024\055\uffd4\057\034\060"
			+ "\015\061\017\063\033\001\002\000\004\055\073\001\002"
			+ "\000\006\054\uffd3\055\uffd3\001\002\000\012\036\070\037"
			+ "\067\054\uffd2\055\uffd2\001\002\000\040\002\uffd5\007\uffd5"
			+ "\011\uffd5\012\uffd5\017\uffd5\022\uffd5\023\061\025\uffd5\026"
			+ "\uffd5\027\uffd5\033\062\036\uffd5\037\uffd5\054\uffd5\055\uffd5"
			+ "\001\002\000\026\006\044\021\027\045\031\047\030\051"
			+ "\043\053\024\057\034\060\015\061\017\063\033\001\002"
			+ "\000\026\006\044\021\027\045\031\047\030\051\043\053"
			+ "\024\057\034\060\015\061\017\063\033\001\002\000\052"
			+ "\002\uffce\004\064\007\uffce\011\uffce\012\uffce\013\uffce\015"
			+ "\uffce\017\uffce\022\uffce\023\uffce\025\uffce\026\uffce\027\uffce"
			+ "\030\uffce\031\uffce\033\uffce\036\uffce\037\uffce\054\uffce\055"
			+ "\uffce\001\002\000\026\006\044\021\027\045\031\047\030"
			+ "\051\043\053\024\057\034\060\015\061\017\063\033\001"
			+ "\002\000\052\002\uffcc\004\uffcc\007\uffcc\011\uffcc\012\uffcc"
			+ "\013\uffcc\015\uffcc\017\uffcc\022\uffcc\023\uffcc\025\uffcc\026"
			+ "\uffcc\027\uffcc\030\uffcc\031\uffcc\033\uffcc\036\uffcc\037\uffcc"
			+ "\054\uffcc\055\uffcc\001\002\000\052\002\uffcf\004\064\007"
			+ "\uffcf\011\uffcf\012\uffcf\013\uffcf\015\uffcf\017\uffcf\022\uffcf"
			+ "\023\uffcf\025\uffcf\026\uffcf\027\uffcf\030\uffcf\031\uffcf\033"
			+ "\uffcf\036\uffcf\037\uffcf\054\uffcf\055\uffcf\001\002\000\026"
			+ "\006\044\021\027\045\031\047\030\051\043\053\024\057"
			+ "\034\060\015\061\017\063\033\001\002\000\026\006\044"
			+ "\021\027\045\031\047\030\051\043\053\024\057\034\060"
			+ "\015\061\017\063\033\001\002\000\040\002\uffd6\007\uffd6"
			+ "\011\uffd6\012\uffd6\017\uffd6\022\uffd6\023\061\025\uffd6\026"
			+ "\uffd6\027\uffd6\033\062\036\uffd6\037\uffd6\054\uffd6\055\uffd6"
			+ "\001\002\000\006\054\uffd1\055\uffd1\001\002\000\102\002"
			+ "\uffb7\004\uffb7\007\uffb7\011\uffb7\012\uffb7\013\uffb7\015\uffb7"
			+ "\017\uffb7\022\uffb7\023\uffb7\025\uffb7\026\uffb7\027\uffb7\030"
			+ "\uffb7\031\uffb7\033\uffb7\035\uffb7\036\uffb7\037\uffb7\040\uffb7"
			+ "\041\uffb7\042\uffb7\043\uffb7\044\uffb7\046\uffb7\050\uffb7\051"
			+ "\uffb7\052\uffb7\053\uffb7\054\uffb7\055\uffb7\056\uffb7\001\002"
			+ "\000\024\006\044\045\031\047\030\051\043\053\024\057"
			+ "\034\060\015\061\017\063\033\001\002\000\024\006\044"
			+ "\045\031\047\030\051\043\053\024\057\034\060\015\061"
			+ "\017\063\033\001\002\000\024\006\044\045\031\047\030"
			+ "\051\043\053\024\057\034\060\015\061\017\063\033\001"
			+ "\002\000\100\002\uffc5\004\uffc5\007\uffc5\011\uffc5\012\uffc5"
			+ "\013\uffc5\015\uffc5\017\uffc5\022\uffc5\023\uffc5\025\uffc5\026"
			+ "\uffc5\027\uffc5\030\uffc5\031\uffc5\033\uffc5\035\100\036\uffc5"
			+ "\037\uffc5\040\uffc5\042\uffc5\043\uffc5\044\uffc5\046\uffc5\050"
			+ "\uffc5\051\uffc5\052\uffc5\053\uffc5\054\uffc5\055\uffc5\056\101"
			+ "\001\002\000\024\006\044\045\031\047\030\051\043\053"
			+ "\024\057\034\060\015\061\017\063\033\001\002\000\024"
			+ "\006\044\045\031\047\030\051\043\053\024\057\034\060"
			+ "\015\061\017\063\033\001\002\000\100\002\uffc1\004\uffc1"
			+ "\007\uffc1\011\uffc1\012\uffc1\013\uffc1\015\uffc1\017\uffc1\022"
			+ "\uffc1\023\uffc1\025\uffc1\026\uffc1\027\uffc1\030\uffc1\031\uffc1"
			+ "\033\uffc1\035\uffc1\036\uffc1\037\uffc1\040\uffc1\042\uffc1\043"
			+ "\uffc1\044\uffc1\046\uffc1\050\uffc1\051\uffc1\052\uffc1\053\uffc1"
			+ "\054\uffc1\055\uffc1\056\uffc1\001\002\000\100\002\uffc2\004"
			+ "\uffc2\007\uffc2\011\uffc2\012\uffc2\013\uffc2\015\uffc2\017\uffc2"
			+ "\022\uffc2\023\uffc2\025\uffc2\026\uffc2\027\uffc2\030\uffc2\031"
			+ "\uffc2\033\uffc2\035\uffc2\036\uffc2\037\uffc2\040\uffc2\042\uffc2"
			+ "\043\uffc2\044\uffc2\046\uffc2\050\uffc2\051\uffc2\052\uffc2\053"
			+ "\uffc2\054\uffc2\055\uffc2\056\uffc2\001\002\000\100\002\uffc4"
			+ "\004\uffc4\007\uffc4\011\uffc4\012\uffc4\013\uffc4\015\uffc4\017"
			+ "\uffc4\022\uffc4\023\uffc4\025\uffc4\026\uffc4\027\uffc4\030\uffc4"
			+ "\031\uffc4\033\uffc4\035\100\036\uffc4\037\uffc4\040\uffc4\042"
			+ "\uffc4\043\uffc4\044\uffc4\046\uffc4\050\uffc4\051\uffc4\052\uffc4"
			+ "\053\uffc4\054\uffc4\055\uffc4\056\101\001\002\000\100\002"
			+ "\uffc6\004\uffc6\007\uffc6\011\uffc6\012\uffc6\013\uffc6\015\uffc6"
			+ "\017\uffc6\022\uffc6\023\uffc6\025\uffc6\026\uffc6\027\uffc6\030"
			+ "\uffc6\031\uffc6\033\uffc6\035\100\036\uffc6\037\uffc6\040\uffc6"
			+ "\042\uffc6\043\uffc6\044\uffc6\046\uffc6\050\uffc6\051\uffc6\052"
			+ "\uffc6\053\uffc6\054\uffc6\055\uffc6\056\101\001\002\000\014"
			+ "\013\uffb0\015\uffb0\023\061\031\uffb0\033\062\001\002\000"
			+ "\010\013\uffaf\015\uffaf\031\uffaf\001\002\000\010\013\112"
			+ "\015\uffac\031\113\001\002\000\004\015\121\001\002\000"
			+ "\026\006\044\021\027\045\031\047\030\051\043\053\024"
			+ "\057\034\060\015\061\017\063\033\001\002\000\026\006"
			+ "\044\021\027\045\031\047\030\051\043\053\024\057\034"
			+ "\060\015\061\017\063\033\001\002\000\010\013\uffae\015"
			+ "\uffae\031\uffae\001\002\000\010\023\061\030\116\033\062"
			+ "\001\002\000\026\006\044\021\027\045\031\047\030\051"
			+ "\043\053\024\057\034\060\015\061\017\063\033\001\002"
			+ "\000\014\013\uffad\015\uffad\023\061\031\uffad\033\062\001"
			+ "\002\000\010\015\uffab\023\061\033\062\001\002\000\102"
			+ "\002\uffb2\004\uffb2\007\uffb2\011\uffb2\012\uffb2\013\uffb2\015"
			+ "\uffb2\017\uffb2\022\uffb2\023\uffb2\025\uffb2\026\uffb2\027\uffb2"
			+ "\030\uffb2\031\uffb2\033\uffb2\035\uffb2\036\uffb2\037\uffb2\040"
			+ "\uffb2\041\uffb2\042\uffb2\043\uffb2\044\uffb2\046\uffb2\050\uffb2"
			+ "\051\uffb2\052\uffb2\053\uffb2\054\uffb2\055\uffb2\056\uffb2\001"
			+ "\002\000\102\002\uffbe\004\uffbe\007\uffbe\011\uffbe\012\uffbe"
			+ "\013\uffbe\015\uffbe\017\uffbe\022\uffbe\023\uffbe\025\uffbe\026"
			+ "\uffbe\027\uffbe\030\uffbe\031\uffbe\033\uffbe\035\uffbe\036\uffbe"
			+ "\037\uffbe\040\uffbe\041\047\042\uffbe\043\uffbe\044\uffbe\046"
			+ "\uffbe\050\uffbe\051\uffbe\052\uffbe\053\uffbe\054\uffbe\055\uffbe"
			+ "\056\uffbe\001\002\000\024\006\uffa8\045\uffa8\047\uffa8\051"
			+ "\uffa8\053\uffa8\057\uffa8\060\uffa8\061\uffa8\063\uffa8\001\002"
			+ "\000\024\006\uffaa\045\uffaa\047\uffaa\051\uffaa\053\uffaa\057"
			+ "\uffaa\060\uffaa\061\uffaa\063\uffaa\001\002\000\024\006\uffa7"
			+ "\045\uffa7\047\uffa7\051\uffa7\053\uffa7\057\uffa7\060\uffa7\061"
			+ "\uffa7\063\uffa7\001\002\000\024\006\uffa6\045\uffa6\047\uffa6"
			+ "\051\uffa6\053\uffa6\057\uffa6\060\uffa6\061\uffa6\063\uffa6\001"
			+ "\002\000\024\006\uffa5\045\uffa5\047\uffa5\051\uffa5\053\uffa5"
			+ "\057\uffa5\060\uffa5\061\uffa5\063\uffa5\001\002\000\024\006"
			+ "\uffa9\045\uffa9\047\uffa9\051\uffa9\053\uffa9\057\uffa9\060\uffa9"
			+ "\061\uffa9\063\uffa9\001\002\000\024\006\044\045\031\047"
			+ "\030\051\043\053\024\057\034\060\015\061\017\063\033"
			+ "\001\002\000\074\002\uffc8\004\uffc8\007\uffc8\011\uffc8\012"
			+ "\uffc8\013\uffc8\015\uffc8\017\uffc8\022\uffc8\023\uffc8\025\uffc8"
			+ "\026\uffc8\027\uffc8\030\uffc8\031\uffc8\033\uffc8\036\uffc8\037"
			+ "\uffc8\040\075\042\uffc8\043\uffc8\044\uffc8\046\uffc8\050\uffc8"
			+ "\051\076\052\uffc8\053\074\054\uffc8\055\uffc8\001\002\000"
			+ "\006\060\015\061\017\001\002\000\012\012\uffe2\017\uffe2"
			+ "\026\uffe2\027\uffe2\001\002\000\004\042\142\001\002\000"
			+ "\014\012\uffdf\017\uffdf\026\uffdf\027\uffdf\037\140\001\002"
			+ "\000\012\012\uffe0\017\uffe0\026\uffe0\027\uffe0\001\002\000"
			+ "\006\060\015\061\017\001\002\000\012\012\uffde\017\uffde"
			+ "\026\uffde\027\uffde\001\002\000\026\006\044\021\027\045"
			+ "\031\047\030\051\043\053\024\057\034\060\015\061\017"
			+ "\063\033\001\002\000\020\012\uffdd\017\uffdd\023\061\026"
			+ "\uffdd\027\uffdd\033\062\037\uffdd\001\002\000\010\023\061"
			+ "\025\145\033\062\001\002\000\014\012\uffe1\017\uffe1\026"
			+ "\uffe1\027\uffe1\037\133\001\002\000\012\012\uffe3\017\uffe3"
			+ "\026\uffe3\027\uffe3\001\002\000\004\054\150\001\002\000"
			+ "\102\002\uffb4\004\uffb4\007\uffb4\011\uffb4\012\uffb4\013\uffb4"
			+ "\015\uffb4\017\uffb4\022\uffb4\023\uffb4\025\uffb4\026\uffb4\027"
			+ "\uffb4\030\uffb4\031\uffb4\033\uffb4\035\uffb4\036\uffb4\037\uffb4"
			+ "\040\uffb4\041\uffb4\042\uffb4\043\uffb4\044\uffb4\046\uffb4\050"
			+ "\uffb4\051\uffb4\052\uffb4\053\uffb4\054\uffb4\055\uffb4\056\uffb4"
			+ "\001\002\000\004\055\152\001\002\000\102\002\uffb5\004"
			+ "\uffb5\007\uffb5\011\uffb5\012\uffb5\013\uffb5\015\uffb5\017\uffb5"
			+ "\022\uffb5\023\uffb5\025\uffb5\026\uffb5\027\uffb5\030\uffb5\031"
			+ "\uffb5\033\uffb5\035\uffb5\036\uffb5\037\uffb5\040\uffb5\041\uffb5"
			+ "\042\uffb5\043\uffb5\044\uffb5\046\uffb5\050\uffb5\051\uffb5\052"
			+ "\uffb5\053\uffb5\054\uffb5\055\uffb5\056\uffb5\001\002\000\052"
			+ "\002\uffca\004\uffca\007\uffca\011\uffca\012\uffca\013\uffca\015"
			+ "\uffca\017\uffca\022\uffca\023\uffca\025\uffca\026\uffca\027\uffca"
			+ "\030\uffca\031\uffca\033\uffca\036\uffca\037\uffca\054\uffca\055"
			+ "\uffca\001\002\000\030\006\044\021\027\045\031\047\030"
			+ "\051\043\053\024\055\uffd4\057\034\060\015\061\017\063"
			+ "\033\001\002\000\004\055\156\001\002\000\102\002\uffb6"
			+ "\004\uffb6\007\uffb6\011\uffb6\012\uffb6\013\uffb6\015\uffb6\017"
			+ "\uffb6\022\uffb6\023\uffb6\025\uffb6\026\uffb6\027\uffb6\030\uffb6"
			+ "\031\uffb6\033\uffb6\035\uffb6\036\uffb6\037\uffb6\040\uffb6\041"
			+ "\uffb6\042\uffb6\043\uffb6\044\uffb6\046\uffb6\050\uffb6\051\uffb6"
			+ "\052\uffb6\053\uffb6\054\uffb6\055\uffb6\056\uffb6\001\002\000"
			+ "\102\002\uffbf\004\uffbf\007\uffbf\011\uffbf\012\uffbf\013\uffbf"
			+ "\015\uffbf\017\uffbf\022\uffbf\023\uffbf\025\uffbf\026\uffbf\027"
			+ "\uffbf\030\uffbf\031\uffbf\033\uffbf\035\uffbf\036\uffbf\037\uffbf"
			+ "\040\uffbf\041\047\042\uffbf\043\uffbf\044\uffbf\046\uffbf\050"
			+ "\uffbf\051\uffbf\052\uffbf\053\uffbf\054\uffbf\055\uffbf\056\uffbf"
			+ "\001\002\000\006\005\161\041\022\001\002\000\030\006"
			+ "\044\021\027\025\162\045\031\047\030\051\043\053\024"
			+ "\057\034\060\015\061\017\063\033\001\002\000\026\006"
			+ "\044\021\027\045\031\047\030\051\043\053\024\057\034"
			+ "\060\015\061\017\063\033\001\002\000\014\012\uffdb\017"
			+ "\uffdb\026\uffdb\027\uffdb\036\070\001\002\000\006\025\165"
			+ "\036\070\001\002\000\012\012\uffdc\017\uffdc\026\uffdc\027"
			+ "\uffdc\001\002\000\006\012\uffe6\026\uffe6\001\002\000\004"
			+ "\026\233\001\002\000\032\006\ufff2\016\ufffb\020\176\021"
			+ "\ufff2\045\ufff2\047\ufff2\051\ufff2\053\ufff2\057\ufff2\060\ufff2"
			+ "\061\ufff2\063\ufff2\001\002\000\032\006\uffff\016\uffff\020"
			+ "\uffff\021\uffff\045\uffff\047\uffff\051\uffff\053\uffff\057\uffff"
			+ "\060\uffff\061\uffff\063\uffff\001\002\000\004\016\ufffa\001"
			+ "\002\000\026\006\044\021\027\045\031\047\030\051\043"
			+ "\053\024\057\034\060\015\061\017\063\033\001\002\000"
			+ "\004\016\202\001\002\000\006\016\ufff9\037\200\001\002"
			+ "\000\004\014\177\001\002\000\026\006\ufff1\021\ufff1\045"
			+ "\ufff1\047\ufff1\051\ufff1\053\ufff1\057\ufff1\060\ufff1\061\ufff1"
			+ "\063\ufff1\001\002\000\030\006\ufff2\020\176\021\ufff2\045"
			+ "\ufff2\047\ufff2\051\ufff2\053\ufff2\057\ufff2\060\ufff2\061\ufff2"
			+ "\063\ufff2\001\002\000\004\016\ufff8\001\002\000\006\060"
			+ "\015\061\017\001\002\000\010\002\uffef\007\uffef\032\uffef"
			+ "\001\002\000\010\002\uffee\007\uffee\032\205\001\002\000"
			+ "\026\006\044\021\027\045\031\047\030\051\043\053\024"
			+ "\057\034\060\015\061\017\063\033\001\002\000\006\002"
			+ "\uffec\007\207\001\002\000\004\024\211\001\002\000\004"
			+ "\002\000\001\002\000\006\060\015\061\017\001\002\000"
			+ "\006\002\uffea\037\uffe9\001\002\000\004\002\uffeb\001\002"
			+ "\000\004\037\215\001\002\000\006\060\015\061\017\001"
			+ "\002\000\004\002\uffe8\001\002\000\010\002\uffed\007\uffed"
			+ "\036\070\001\002\000\010\011\222\022\ufff6\036\070\001"
			+ "\002\000\004\022\230\001\002\000\004\024\223\001\002"
			+ "\000\006\060\015\061\017\001\002\000\004\022\ufff5\001"
			+ "\002\000\010\022\ufff4\037\226\041\022\001\002\000\006"
			+ "\060\015\061\017\001\002\000\004\022\ufff3\001\002\000"
			+ "\006\060\015\061\017\001\002\000\006\016\ufff0\037\ufff0"
			+ "\001\002\000\006\016\ufff7\037\ufff7\001\002\000\032\006"
			+ "\ufffe\016\ufffe\020\ufffe\021\ufffe\045\ufffe\047\ufffe\051\ufffe"
			+ "\053\ufffe\057\ufffe\060\ufffe\061\ufffe\063\ufffe\001\002\000"
			+ "\004\002\001\001\002" });

	/** Access to parse-action table. */
	public short[][] action_table() {
		return _action_table;
	}

	/** <code>reduce_goto</code> table. */
	protected static final short[][] _reduce_table = unpackFromStrings(new String[] { "\000\232\000\006\003\003\010\004\001\001\000\002\001"
			+ "\001\000\004\011\167\001\001\000\012\012\010\013\007"
			+ "\014\006\015\011\001\001\000\002\001\001\000\012\012"
			+ "\165\013\007\014\006\015\011\001\001\000\002\001\001"
			+ "\000\002\001\001\000\006\037\015\047\157\001\001\000"
			+ "\006\037\015\047\017\001\001\000\002\001\001\000\002"
			+ "\001\001\000\002\001\001\000\002\001\001\000\026\022"
			+ "\034\024\025\025\045\026\037\027\040\030\041\031\044"
			+ "\032\036\033\035\037\024\001\001\000\004\037\022\001"
			+ "\001\000\002\001\001\000\010\024\025\025\156\037\024"
			+ "\001\001\000\002\001\001\000\002\001\001\000\022\024"
			+ "\025\025\045\027\152\030\041\031\044\032\036\033\035"
			+ "\037\024\001\001\000\032\021\056\022\057\024\025\025"
			+ "\045\026\037\027\040\030\041\031\044\032\036\033\035"
			+ "\037\024\044\150\001\001\000\034\021\056\022\057\024"
			+ "\025\025\045\026\037\027\040\030\041\031\044\032\036"
			+ "\033\035\037\024\043\146\044\055\001\001\000\026\022"
			+ "\143\024\025\025\045\026\037\027\040\030\041\031\044"
			+ "\032\036\033\035\037\024\001\001\000\002\001\001\000"
			+ "\002\001\001\000\004\041\133\001\001\000\002\001\001"
			+ "\000\002\001\001\000\002\001\001\000\002\001\001\000"
			+ "\004\050\130\001\001\000\010\024\025\025\121\037\024"
			+ "\001\001\000\030\022\105\023\106\024\025\025\045\026"
			+ "\037\027\040\030\041\031\044\032\036\033\035\037\024"
			+ "\001\001\000\002\001\001\000\002\001\001\000\004\037"
			+ "\051\001\001\000\002\001\001\000\002\001\001\000\002"
			+ "\001\001\000\002\001\001\000\034\021\056\022\057\024"
			+ "\025\025\045\026\037\027\040\030\041\031\044\032\036"
			+ "\033\035\037\024\043\054\044\055\001\001\000\002\001"
			+ "\001\000\002\001\001\000\002\001\001\000\002\001\001"
			+ "\000\024\024\025\025\045\026\065\027\040\030\041\031"
			+ "\044\032\036\033\035\037\024\001\001\000\024\024\025"
			+ "\025\045\026\062\027\040\030\041\031\044\032\036\033"
			+ "\035\037\024\001\001\000\002\001\001\000\022\024\025"
			+ "\025\045\027\064\030\041\031\044\032\036\033\035\037"
			+ "\024\001\001\000\002\001\001\000\002\001\001\000\032"
			+ "\021\056\022\057\024\025\025\045\026\037\027\040\030"
			+ "\041\031\044\032\036\033\035\037\024\044\071\001\001"
			+ "\000\026\022\070\024\025\025\045\026\037\027\040\030"
			+ "\041\031\044\032\036\033\035\037\024\001\001\000\002"
			+ "\001\001\000\002\001\001\000\002\001\001\000\014\024"
			+ "\025\025\045\032\104\033\035\037\024\001\001\000\014"
			+ "\024\025\025\045\032\103\033\035\037\024\001\001\000"
			+ "\014\024\025\025\045\032\076\033\035\037\024\001\001"
			+ "\000\002\001\001\000\012\024\025\025\045\033\102\037"
			+ "\024\001\001\000\012\024\025\025\045\033\101\037\024"
			+ "\001\001\000\002\001\001\000\002\001\001\000\002\001"
			+ "\001\000\002\001\001\000\002\001\001\000\004\045\107"
			+ "\001\001\000\006\034\110\035\113\001\001\000\002\001"
			+ "\001\000\026\022\117\024\025\025\045\026\037\027\040"
			+ "\030\041\031\044\032\036\033\035\037\024\001\001\000"
			+ "\026\022\114\024\025\025\045\026\037\027\040\030\041"
			+ "\031\044\032\036\033\035\037\024\001\001\000\002\001"
			+ "\001\000\002\001\001\000\026\022\116\024\025\025\045"
			+ "\026\037\027\040\030\041\031\044\032\036\033\035\037"
			+ "\024\001\001\000\002\001\001\000\002\001\001\000\002"
			+ "\001\001\000\002\001\001\000\002\001\001\000\002\001"
			+ "\001\000\002\001\001\000\002\001\001\000\002\001\001"
			+ "\000\002\001\001\000\016\024\025\025\045\031\131\032"
			+ "\036\033\035\037\024\001\001\000\002\001\001\000\010"
			+ "\037\134\042\136\046\135\001\001\000\002\001\001\000"
			+ "\002\001\001\000\002\001\001\000\002\001\001\000\010"
			+ "\037\134\042\140\046\135\001\001\000\002\001\001\000"
			+ "\026\022\142\024\025\025\045\026\037\027\040\030\041"
			+ "\031\044\032\036\033\035\037\024\001\001\000\002\001"
			+ "\001\000\002\001\001\000\004\041\145\001\001\000\002"
			+ "\001\001\000\002\001\001\000\002\001\001\000\002\001"
			+ "\001\000\002\001\001\000\002\001\001\000\034\021\056"
			+ "\022\057\024\025\025\045\026\037\027\040\030\041\031"
			+ "\044\032\036\033\035\037\024\043\154\044\055\001\001"
			+ "\000\002\001\001\000\002\001\001\000\002\001\001\000"
			+ "\002\001\001\000\030\021\162\022\057\024\025\025\045"
			+ "\026\037\027\040\030\041\031\044\032\036\033\035\037"
			+ "\024\001\001\000\030\021\163\022\057\024\025\025\045"
			+ "\026\037\027\040\030\041\031\044\032\036\033\035\037"
			+ "\024\001\001\000\002\001\001\000\002\001\001\000\002"
			+ "\001\001\000\002\001\001\000\002\001\001\000\012\016"
			+ "\173\017\171\020\174\036\172\001\001\000\002\001\001"
			+ "\000\002\001\001\000\030\021\217\022\057\024\025\025"
			+ "\045\026\037\027\040\030\041\031\044\032\036\033\035"
			+ "\037\024\001\001\000\002\001\001\000\002\001\001\000"
			+ "\002\001\001\000\002\001\001\000\010\017\200\020\174"
			+ "\036\172\001\001\000\002\001\001\000\006\004\203\037"
			+ "\202\001\001\000\002\001\001\000\004\005\205\001\001"
			+ "\000\030\021\216\022\057\024\025\025\045\026\037\027"
			+ "\040\030\041\031\044\032\036\033\035\037\024\001\001"
			+ "\000\004\006\207\001\001\000\002\001\001\000\002\001"
			+ "\001\000\006\007\212\037\211\001\001\000\004\053\213"
			+ "\001\001\000\002\001\001\000\002\001\001\000\006\007"
			+ "\215\037\211\001\001\000\002\001\001\000\002\001\001"
			+ "\000\004\051\220\001\001\000\002\001\001\000\002\001"
			+ "\001\000\010\037\015\047\224\052\223\001\001\000\002"
			+ "\001\001\000\002\001\001\000\010\037\015\047\224\052"
			+ "\226\001\001\000\002\001\001\000\006\037\230\040\231"
			+ "\001\001\000\002\001\001\000\002\001\001\000\002\001"
			+ "\001\000\002\001\001" });

	/** Access to <code>reduce_goto</code> table. */
	public short[][] reduce_table() {
		return _reduce_table;
	}

	/** Instance of action encapsulation class. */
	protected CUP$parser$actions action_obj;

	/** Action encapsulation object initializer. */
	protected void init_actions() {
		action_obj = new CUP$parser$actions(this);
	}

	/** Invoke a user supplied parse action. */
	public java_cup.runtime.Symbol do_action(int act_num,
			java_cup.runtime.lr_parser parser, java.util.Stack stack, int top)
			throws java.lang.Exception {
		/* call code in generated class */
		return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
	}

	/** Indicates start state. */
	public int start_state() {
		return 0;
	}

	/** Indicates start production. */
	public int start_production() {
		return 0;
	}

	/** <code>EOF</code> Symbol index. */
	public int EOF_sym() {
		return 0;
	}

	/** <code>error</code> Symbol index. */
	public int error_sym() {
		return 1;
	}

	static Logger logger = Logger.getLogger(parser.class);

	/**
	 * report_error
	 */
	public void report_error(String message, Object info) {
		logger.warn("Parsing MDX:" + message);
		if (info instanceof Symbol) {
			if (((Symbol) info).left != -1) {
				logger.warn("at character " + ((Symbol) info).left
						+ " of input");
			}
		}
	}

	/**
	 * report_fatal_error
	 */
	public void report_fatal_error(String message, Object info)
			throws Exception {
		String err;
		err = "Fatal error parsing MDX:" + message;
		if (info instanceof Symbol) {
			if (((Symbol) info).left != -1) {
				err += "\n at character " + ((Symbol) info).left + " of input";
			} else {
				err += "\n invalid symbol \"" + ((Symbol) info).value + "\"";
			}
		} else
			err += "\n" + info.toString();
		logger.error("Fatal error parsing MDX:" + err);
		throw new Exception(err);
	}

}

/** Cup generated class to encapsulate user supplied action code. */
class CUP$parser$actions {

	ParsedQuery pQuery = new ParsedQuery();
	private final parser parser;

	/** Constructor */
	CUP$parser$actions(parser parser) {
		this.parser = parser;
	}

	/** Method with the actual generated action code. */
	public final java_cup.runtime.Symbol CUP$parser$do_action(
			int CUP$parser$act_num,
			java_cup.runtime.lr_parser CUP$parser$parser,
			java.util.Stack CUP$parser$stack, int CUP$parser$top)
			throws java.lang.Exception {
		/* Symbol object for return from actions */
		java_cup.runtime.Symbol CUP$parser$result;

		/* select the action based on the action number */
		switch (CUP$parser$act_num) {
		/* . . . . . . . . . . . . . . . . . . . . */
		case 92: // comp_op ::= GE
		{
			String RESULT = null;
			RESULT = ">=";
			CUP$parser$result = new java_cup.runtime.Symbol(38/* comp_op */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 91: // comp_op ::= LE
		{
			String RESULT = null;
			RESULT = "<=";
			CUP$parser$result = new java_cup.runtime.Symbol(38/* comp_op */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 90: // comp_op ::= GT
		{
			String RESULT = null;
			RESULT = ">";
			CUP$parser$result = new java_cup.runtime.Symbol(38/* comp_op */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 89: // comp_op ::= LT
		{
			String RESULT = null;
			RESULT = "<";
			CUP$parser$result = new java_cup.runtime.Symbol(38/* comp_op */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 88: // comp_op ::= NE
		{
			String RESULT = null;
			RESULT = "<>";
			CUP$parser$result = new java_cup.runtime.Symbol(38/* comp_op */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 87: // comp_op ::= EQ
		{
			String RESULT = null;
			RESULT = "=";
			CUP$parser$result = new java_cup.runtime.Symbol(38/* comp_op */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 86: // else_clause_opt ::= ELSE value_expression
		{
			Exp RESULT = null;
			int xleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int xright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			Exp x = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = x;
			CUP$parser$result = new java_cup.runtime.Symbol(
					26/* else_clause_opt */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 1)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 85: // else_clause_opt ::=
		{
			Exp RESULT = null;

			CUP$parser$result = new java_cup.runtime.Symbol(
					26/* else_clause_opt */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 84: // when_clause ::= WHEN value_expression THEN value_expression
		{
			Exp[] RESULT = null;
			int xleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).left;
			int xright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).right;
			Exp x = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).value;
			int yleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int yright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			Exp y = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = new Exp[] { x, y };
			CUP$parser$result = new java_cup.runtime.Symbol(27/* when_clause */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 3)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 83: // when_list ::= when_list when_clause
		{
			ArrayList RESULT = null;
			int xleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).left;
			int xright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).right;
			ArrayList x = (ArrayList) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).value;
			int yleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int yright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			Exp[] y = (Exp[]) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = x;
			x.add(y);
			CUP$parser$result = new java_cup.runtime.Symbol(35/* when_list */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 1)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 82: // when_list ::=
		{
			ArrayList RESULT = null;
			RESULT = new ArrayList();
			CUP$parser$result = new java_cup.runtime.Symbol(35/* when_list */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 81: // value_expression_opt ::= value_expression
		{
			Exp RESULT = null;

			// Default action for single-symbol production
			RESULT = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top)).value;
			CUP$parser$result = new java_cup.runtime.Symbol(
					17/* value_expression_opt */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 80: // value_expression_opt ::=
		{
			Exp RESULT = null;

			CUP$parser$result = new java_cup.runtime.Symbol(
					17/* value_expression_opt */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 79: // case_expression ::= CASE value_expression_opt when_list
			// else_clause_opt END
		{
			Exp RESULT = null;
			int xleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 3)).left;
			int xright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 3)).right;
			Exp x = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 3)).value;
			int yleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).left;
			int yright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).right;
			ArrayList y = (ArrayList) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).value;
			int zleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).left;
			int zright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).right;
			Exp z = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).value;
			ArrayList v = new ArrayList();
			if (x != null) {
				v.add(x);
			}
			for (int i = 0; i < y.size(); i++) {
				Exp[] exps = (Exp[]) y.get(i);
				// Util.assertTrue(exps.length == 2);
				v.add(exps[0]);
				v.add(exps[1]);
			}
			if (z != null) {
				v.add(z);
			}
			if (x == null) {
				RESULT = new FunCall("_CaseTest",
						(Exp[]) v.toArray(new Exp[0]), FunCall.TypeCase);
			} else {
				RESULT = new FunCall("_CaseMatch", (Exp[]) v
						.toArray(new Exp[0]), FunCall.TypeCase);
			}

			CUP$parser$result = new java_cup.runtime.Symbol(
					18/* case_expression */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 4)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 78: // value_expression_primary ::= case_expression
		{
			Exp RESULT = null;

			// Default action for single-symbol production
			RESULT = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top)).value;
			CUP$parser$result = new java_cup.runtime.Symbol(
					19/* value_expression_primary */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 77: // value_expression_primary ::= LBRACE exp_list_opt RBRACE
		{
			Exp RESULT = null;
			int lisleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).left;
			int lisright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).right;
			ArrayList lis = (ArrayList) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).value;
			// set built from sets/tuples
			RESULT = new FunCall("{}", (Exp[]) lis.toArray(new Exp[0]),
					FunCall.TypeBraces);

			CUP$parser$result = new java_cup.runtime.Symbol(
					19/* value_expression_primary */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 2)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 76: // value_expression_primary ::= LPAREN exp_list RPAREN
		{
			Exp RESULT = null;
			int lisleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).left;
			int lisright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).right;
			ArrayList lis = (ArrayList) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).value;

			// Whereas ([Sales],[Time]) and () are tuples, ([Sales]) and (5)
			// are just expressions.
			RESULT = new FunCall("()", (Exp[]) lis.toArray(new Exp[0]),
					FunCall.TypeParentheses);

			CUP$parser$result = new java_cup.runtime.Symbol(
					19/* value_expression_primary */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 2)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 75: // value_expression_primary ::= identifier LPAREN exp_list_opt
			// RPAREN
		{
			Exp RESULT = null;
			int ileft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 3)).left;
			int iright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 3)).right;
			String i = (String) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 3)).value;
			int lisleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).left;
			int lisright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).right;
			ArrayList lis = (ArrayList) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).value;
			RESULT = new FunCall(i, (Exp[]) lis.toArray(new Exp[0]),
					FunCall.TypeFunction);
			CUP$parser$result = new java_cup.runtime.Symbol(
					19/* value_expression_primary */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 3)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 74: // value_expression_primary ::= value_expression_primary DOT
			// identifier LPAREN exp_list_opt RPAREN
		{
			Exp RESULT = null;
			int ileft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 5)).left;
			int iright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 5)).right;
			Exp i = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 5)).value;
			int jleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 3)).left;
			int jright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 3)).right;
			String j = (String) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 3)).value;
			int lisleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).left;
			int lisright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).right;
			ArrayList lis = (ArrayList) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).value;
			lis.add(0, i);
			RESULT = new FunCall(j, (Exp[]) lis.toArray(new Exp[0]),
					FunCall.TypeMethod);
			CUP$parser$result = new java_cup.runtime.Symbol(
					19/* value_expression_primary */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 5)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 73: // value_expression_primary ::= value_expression_primary DOT
			// AMP_QUOTED_ID
		{
			Exp RESULT = null;
			int ileft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).left;
			int iright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).right;
			Exp i = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).value;
			int jleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int jright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			String j = (String) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;

			if (i instanceof CompoundId) {
				((CompoundId) i).append(j, true);
				RESULT = i;
			} else {
				RESULT = new FunCall(j, new Exp[] { i },
						FunCall.TypePropertyAmpQuoted);
			}

			CUP$parser$result = new java_cup.runtime.Symbol(
					19/* value_expression_primary */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 2)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 72: // value_expression_primary ::= value_expression_primary DOT
			// QUOTED_ID
		{
			Exp RESULT = null;
			int ileft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).left;
			int iright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).right;
			Exp i = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).value;
			int jleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int jright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			String j = (String) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;

			if (i instanceof CompoundId) {
				((CompoundId) i).append(j);
				RESULT = i;
			} else {
				RESULT = new FunCall(j, new Exp[] { i },
						FunCall.TypePropertyQuoted);
			}

			CUP$parser$result = new java_cup.runtime.Symbol(
					19/* value_expression_primary */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 2)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 71: // value_expression_primary ::= value_expression_primary DOT ID
		{
			Exp RESULT = null;
			int ileft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).left;
			int iright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).right;
			Exp i = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).value;
			int jleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int jright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			String j = (String) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = new FunCall(j, new Exp[] { i }, FunCall.TypeProperty);
			CUP$parser$result = new java_cup.runtime.Symbol(
					19/* value_expression_primary */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 2)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 70: // value_expression_primary ::= identifier
		{
			Exp RESULT = null;
			int ileft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int iright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			String i = (String) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = new CompoundId(i);
			CUP$parser$result = new java_cup.runtime.Symbol(
					19/* value_expression_primary */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 69: // value_expression_primary ::= NUMBER
		{
			Exp RESULT = null;
			int dleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int dright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			Double d = (Double) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = Literal.create(d);
			CUP$parser$result = new java_cup.runtime.Symbol(
					19/* value_expression_primary */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 68: // value_expression_primary ::= STRING
		{
			Exp RESULT = null;
			int sleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int sright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			String s = (String) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = Literal.createString(s);
			CUP$parser$result = new java_cup.runtime.Symbol(
					19/* value_expression_primary */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 67: // factor ::= MINUS value_expression_primary
		{
			Exp RESULT = null;
			int pleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int pright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			Exp p = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = new FunCall("-", new Exp[] { p }, FunCall.TypePrefix);
			CUP$parser$result = new java_cup.runtime.Symbol(25/* factor */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 1)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 66: // factor ::= PLUS value_expression_primary
		{
			Exp RESULT = null;
			int pleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int pright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			Exp p = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = p;
			CUP$parser$result = new java_cup.runtime.Symbol(25/* factor */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 1)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 65: // factor ::= value_expression_primary
		{
			Exp RESULT = null;
			int tleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int tright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			Exp t = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = t;
			CUP$parser$result = new java_cup.runtime.Symbol(25/* factor */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 64: // term ::= term SOLIDUS factor
		{
			Exp RESULT = null;
			int xleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).left;
			int xright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).right;
			Exp x = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).value;
			int yleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int yright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			Exp y = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = new FunCall("/", new Exp[] { x, y }, FunCall.TypeInfix);
			CUP$parser$result = new java_cup.runtime.Symbol(24/* term */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 2)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 63: // term ::= term ASTERISK factor
		{
			Exp RESULT = null;
			int xleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).left;
			int xright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).right;
			Exp x = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).value;
			int yleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int yright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			Exp y = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = new FunCall("*", new Exp[] { x, y }, FunCall.TypeInfix);
			CUP$parser$result = new java_cup.runtime.Symbol(24/* term */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 2)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 62: // term ::= factor
		{
			Exp RESULT = null;
			int tleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int tright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			Exp t = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = t;
			CUP$parser$result = new java_cup.runtime.Symbol(24/* term */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 61: // term2 ::= term2 CONCAT term
		{
			Exp RESULT = null;
			int xleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).left;
			int xright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).right;
			Exp x = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).value;
			int yleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int yright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			Exp y = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = new FunCall("||", new Exp[] { x, y }, FunCall.TypeInfix);
			CUP$parser$result = new java_cup.runtime.Symbol(23/* term2 */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 2)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 60: // term2 ::= term2 MINUS term
		{
			Exp RESULT = null;
			int xleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).left;
			int xright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).right;
			Exp x = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).value;
			int yleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int yright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			Exp y = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = new FunCall("-", new Exp[] { x, y }, FunCall.TypeInfix);
			CUP$parser$result = new java_cup.runtime.Symbol(23/* term2 */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 2)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 59: // term2 ::= term2 PLUS term
		{
			Exp RESULT = null;
			int xleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).left;
			int xright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).right;
			Exp x = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).value;
			int yleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int yright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			Exp y = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = new FunCall("+", new Exp[] { x, y }, FunCall.TypeInfix);
			CUP$parser$result = new java_cup.runtime.Symbol(23/* term2 */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 2)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 58: // term2 ::= term
		{
			Exp RESULT = null;
			int tleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int tright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			Exp t = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = t;
			CUP$parser$result = new java_cup.runtime.Symbol(23/* term2 */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 57: // term3 ::= term3 comp_op term2
		{
			Exp RESULT = null;
			int xleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).left;
			int xright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).right;
			Exp x = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).value;
			int opleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).left;
			int opright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).right;
			String op = (String) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).value;
			int yleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int yright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			Exp y = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = new FunCall(op, new Exp[] { x, y }, FunCall.TypeInfix);
			CUP$parser$result = new java_cup.runtime.Symbol(22/* term3 */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 2)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 56: // term3 ::= term2
		{
			Exp RESULT = null;
			int tleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int tright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			Exp t = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = t;
			CUP$parser$result = new java_cup.runtime.Symbol(22/* term3 */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 55: // term4 ::= NOT term4
		{
			Exp RESULT = null;
			int pleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int pright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			Exp p = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = new FunCall("NOT", new Exp[] { p }, FunCall.TypePrefix);
			CUP$parser$result = new java_cup.runtime.Symbol(21/* term4 */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 1)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 54: // term4 ::= term3
		{
			Exp RESULT = null;
			int tleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int tright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			Exp t = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = t;
			CUP$parser$result = new java_cup.runtime.Symbol(21/* term4 */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 53: // term5 ::= term5 AND term4
		{
			Exp RESULT = null;
			int xleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).left;
			int xright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).right;
			Exp x = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).value;
			int yleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int yright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			Exp y = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = new FunCall("AND", new Exp[] { x, y }, FunCall.TypeInfix);
			CUP$parser$result = new java_cup.runtime.Symbol(20/* term5 */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 2)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 52: // term5 ::= term4
		{
			Exp RESULT = null;
			int tleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int tright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			Exp t = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = t;
			CUP$parser$result = new java_cup.runtime.Symbol(20/* term5 */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 51: // value_expression ::= value_expression XOR term5
		{
			Exp RESULT = null;
			int xleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).left;
			int xright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).right;
			Exp x = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).value;
			int yleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int yright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			Exp y = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = new FunCall("XOR", new Exp[] { x, y }, FunCall.TypeInfix);
			CUP$parser$result = new java_cup.runtime.Symbol(
					16/* value_expression */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 2)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 50: // value_expression ::= value_expression OR term5
		{
			Exp RESULT = null;
			int xleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).left;
			int xright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).right;
			Exp x = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).value;
			int yleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int yright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			Exp y = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = new FunCall("OR", new Exp[] { x, y }, FunCall.TypeInfix);
			CUP$parser$result = new java_cup.runtime.Symbol(
					16/* value_expression */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 2)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 49: // value_expression ::= term5
		{
			Exp RESULT = null;
			int tleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int tright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			Exp t = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = t;
			CUP$parser$result = new java_cup.runtime.Symbol(
					16/* value_expression */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 48: // exp_list ::= expression COMMA exp_list
		{
			ArrayList RESULT = null;
			int eleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).left;
			int eright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).right;
			Exp e = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).value;
			int listleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int listright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			ArrayList list = (ArrayList) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			list.add(0, e);
			RESULT = list;
			CUP$parser$result = new java_cup.runtime.Symbol(34/* exp_list */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 2)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 47: // exp_list ::= expression
		{
			ArrayList RESULT = null;
			int eleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int eright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			Exp e = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = new ArrayList();
			RESULT.add(e);
			CUP$parser$result = new java_cup.runtime.Symbol(34/* exp_list */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 46: // exp_list_opt ::= exp_list
		{
			ArrayList RESULT = null;
			int xleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int xright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			ArrayList x = (ArrayList) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = x;
			CUP$parser$result = new java_cup.runtime.Symbol(33/* exp_list_opt */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 45: // exp_list_opt ::=
		{
			ArrayList RESULT = null;
			RESULT = new ArrayList();
			CUP$parser$result = new java_cup.runtime.Symbol(33/* exp_list_opt */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 44: // expression ::= value_expression
		{
			Exp RESULT = null;
			int vleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int vright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			Exp v = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = v;
			CUP$parser$result = new java_cup.runtime.Symbol(15/* expression */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 43: // expression ::= expression COLON value_expression
		{
			Exp RESULT = null;
			int xleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).left;
			int xright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).right;
			Exp x = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).value;
			int yleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int yright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			Exp y = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			// range yields set
			RESULT = new FunCall(":", new Exp[] { x, y }, FunCall.TypeInfix);

			CUP$parser$result = new java_cup.runtime.Symbol(15/* expression */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 2)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 42: // identifier ::= QUOTED_ID
		{
			String RESULT = null;
			int yleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int yright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			String y = (String) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = y;
			CUP$parser$result = new java_cup.runtime.Symbol(29/* identifier */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 41: // identifier ::= ID
		{
			String RESULT = null;
			int xleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int xright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			String x = (String) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = x;
			CUP$parser$result = new java_cup.runtime.Symbol(29/* identifier */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 40: // compound_id ::= compound_id DOT identifier
		{
			CompoundId RESULT = null;
			int hdleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).left;
			int hdright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).right;
			CompoundId hd = (CompoundId) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).value;
			int tlleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int tlright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			String tl = (String) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			hd.append(tl);
			RESULT = hd;
			CUP$parser$result = new java_cup.runtime.Symbol(37/* compound_id */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 2)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 39: // compound_id ::= identifier
		{
			CompoundId RESULT = null;
			int ileft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int iright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			String i = (String) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = new CompoundId(i);
			CUP$parser$result = new java_cup.runtime.Symbol(37/* compound_id */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 38: // set_spec ::= SET compound_id AS expression
		{
			Formula RESULT = null;
			int sleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).left;
			int sright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).right;
			CompoundId s = (CompoundId) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).value;
			int eleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int eright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			Exp e = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = new Formula(s.toStringArray(), e);
			CUP$parser$result = new java_cup.runtime.Symbol(11/* set_spec */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 3)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 37: // set_spec ::= SET compound_id AS QUOTE expression QUOTE
		{
			Formula RESULT = null;
			int sleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 4)).left;
			int sright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 4)).right;
			CompoundId s = (CompoundId) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 4)).value;
			int eleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).left;
			int eright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).right;
			Exp e = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).value;
			RESULT = new Formula(s.toStringArray(), e);
			CUP$parser$result = new java_cup.runtime.Symbol(11/* set_spec */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 5)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 36: // member_property_definition ::= identifier EQ
			// value_expression
		{
			MemberProperty RESULT = null;
			int idleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).left;
			int idright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).right;
			String id = (String) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).value;
			int eleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int eright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			Exp e = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = new MemberProperty(id, e);
			CUP$parser$result = new java_cup.runtime.Symbol(
					36/* member_property_definition */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 2)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 35: // member_property_def_list ::= member_property_definition
			// COMMA member_property_def_list
		{
			ArrayList RESULT = null;
			int hdleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).left;
			int hdright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).right;
			MemberProperty hd = (MemberProperty) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).value;
			int tlleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int tlright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			ArrayList tl = (ArrayList) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = tl;
			RESULT.add(0, hd);
			CUP$parser$result = new java_cup.runtime.Symbol(
					32/* member_property_def_list */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 2)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 34: // member_property_def_list ::= member_property_definition
		{
			ArrayList RESULT = null;
			int mleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int mright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			MemberProperty m = (MemberProperty) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = new ArrayList();
			RESULT.add(m);
			CUP$parser$result = new java_cup.runtime.Symbol(
					32/* member_property_def_list */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 33: // comma_member_property_def_list_opt ::= COMMA
			// member_property_def_list
		{
			ArrayList RESULT = null;
			int lleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int lright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			ArrayList l = (ArrayList) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = l;
			CUP$parser$result = new java_cup.runtime.Symbol(
					31/* comma_member_property_def_list_opt */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 1)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 32: // comma_member_property_def_list_opt ::=
		{
			ArrayList RESULT = null;
			RESULT = new ArrayList();
			CUP$parser$result = new java_cup.runtime.Symbol(
					31/* comma_member_property_def_list_opt */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 31: // member_spec ::= MEMBER compound_id AS value_expression
			// comma_member_property_def_list_opt
		{
			Formula RESULT = null;
			int mleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 3)).left;
			int mright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 3)).right;
			CompoundId m = (CompoundId) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 3)).value;
			int eleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).left;
			int eright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).right;
			Exp e = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).value;
			int lleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int lright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			ArrayList l = (ArrayList) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = new Formula(m.toStringArray(), e, (MemberProperty[]) l
					.toArray(new MemberProperty[0]));
			CUP$parser$result = new java_cup.runtime.Symbol(10/* member_spec */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 4)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 30: // member_spec ::= MEMBER compound_id AS QUOTE value_expression
			// QUOTE comma_member_property_def_list_opt
		{
			Formula RESULT = null;
			int mleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 5)).left;
			int mright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 5)).right;
			CompoundId m = (CompoundId) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 5)).value;
			int eleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).left;
			int eright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).right;
			Exp e = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).value;
			int lleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int lright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			ArrayList l = (ArrayList) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = new Formula(m.toStringArray(), e, (MemberProperty[]) l
					.toArray(new MemberProperty[0]));
			CUP$parser$result = new java_cup.runtime.Symbol(10/* member_spec */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 6)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 29: // single_formula_spec ::= set_spec
		{
			Formula RESULT = null;
			int sleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int sright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			Formula s = (Formula) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = s;
			CUP$parser$result = new java_cup.runtime.Symbol(
					9/* single_formula_spec */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 28: // single_formula_spec ::= member_spec
		{
			Formula RESULT = null;
			int mleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int mright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			Formula m = (Formula) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = m;
			CUP$parser$result = new java_cup.runtime.Symbol(
					9/* single_formula_spec */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 27: // formula_spec ::= single_formula_spec formula_spec
		{
			ArrayList RESULT = null;
			int hdleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).left;
			int hdright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).right;
			Formula hd = (Formula) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).value;
			int tlleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int tlright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			ArrayList tl = (ArrayList) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			tl.add(0, hd);
			RESULT = tl;
			CUP$parser$result = new java_cup.runtime.Symbol(8/* formula_spec */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 1)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 26: // formula_spec ::= single_formula_spec
		{
			ArrayList RESULT = null;
			int eleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int eright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			Formula e = (Formula) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = new ArrayList();
			RESULT.add(e);
			CUP$parser$result = new java_cup.runtime.Symbol(8/* formula_spec */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 25: // cell_prop_list ::= identifier NT$0 COMMA cell_prop_list
		{
			Object RESULT = null;
			// propagate RESULT from NT$0
			if (((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).value != null)
				RESULT = (Object) ((java_cup.runtime.Symbol) CUP$parser$stack
						.elementAt(CUP$parser$top - 2)).value;
			int idleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 3)).left;
			int idright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 3)).right;
			String id = (String) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 3)).value;
			int clleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int clright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			Object cl = (Object) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;

			CUP$parser$result = new java_cup.runtime.Symbol(
					5/* cell_prop_list */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 3)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 24: // NT$0 ::=
		{
			Object RESULT = null;
			int idleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int idright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			String id = (String) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			pQuery.cellProps.add(new CompoundId(id));
			CUP$parser$result = new java_cup.runtime.Symbol(41/* NT$0 */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 23: // cell_prop_list ::= identifier
		{
			Object RESULT = null;
			int idleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int idright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			String id = (String) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			pQuery.cellProps.add(new CompoundId(id));
			CUP$parser$result = new java_cup.runtime.Symbol(
					5/* cell_prop_list */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 22: // cell_prop_def ::= CELL PROPERTIES cell_prop_list
		{
			Object RESULT = null;

			CUP$parser$result = new java_cup.runtime.Symbol(
					4/* cell_prop_def */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 2)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 21: // cell_prop_def ::=
		{
			Object RESULT = null;
			pQuery.cellProps.clear();
			CUP$parser$result = new java_cup.runtime.Symbol(
					4/* cell_prop_def */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 20: // slicer_def ::= WHERE expression
		{
			Object RESULT = null;
			int xleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int xright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			Exp x = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			pQuery.slicer = x;
			CUP$parser$result = new java_cup.runtime.Symbol(3/* slicer_def */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 1)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 19: // slicer_def ::=
		{
			Object RESULT = null;
			pQuery.slicer = null;
			CUP$parser$result = new java_cup.runtime.Symbol(3/* slicer_def */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 18: // cube_def ::= identifier
		{
			Object RESULT = null;
			int xleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int xright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			String x = (String) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			pQuery.setCube(x);
			CUP$parser$result = new java_cup.runtime.Symbol(2/* cube_def */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 17: // axis_name ::= identifier
		{
			String RESULT = null;
			int xleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int xright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			String x = (String) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = x;
			CUP$parser$result = new java_cup.runtime.Symbol(30/* axis_name */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 16: // non_empty_opt ::= NON EMPTY
		{
			Boolean RESULT = null;
			RESULT = new Boolean(true);
			CUP$parser$result = new java_cup.runtime.Symbol(
					28/* non_empty_opt */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 1)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 15: // non_empty_opt ::=
		{
			Boolean RESULT = null;
			RESULT = new Boolean(false);
			CUP$parser$result = new java_cup.runtime.Symbol(
					28/* non_empty_opt */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 14: // dim_prop_list ::= compound_id COMMA dim_prop_list
		{
			List RESULT = null;
			int cid2left = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).left;
			int cid2right = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).right;
			CompoundId cid2 = (CompoundId) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).value;
			int dplleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int dplright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			List dpl = (List) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = dpl;
			dpl.add(cid2);
			CUP$parser$result = new java_cup.runtime.Symbol(
					40/* dim_prop_list */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 2)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 13: // dim_prop_list ::= compound_id
		{
			List RESULT = null;
			int cidleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int cidright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			CompoundId cid = (CompoundId) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			List lst = new ArrayList();
			lst.add(cid);
			RESULT = lst;
			CUP$parser$result = new java_cup.runtime.Symbol(
					40/* dim_prop_list */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 12: // dim_props ::= DIMENSION PROPERTIES dim_prop_list
		{
			List RESULT = null;
			int dplistleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int dplistright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			List dplist = (List) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = dplist;
			CUP$parser$result = new java_cup.runtime.Symbol(39/* dim_props */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 2)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 11: // dim_props ::=
		{
			List RESULT = null;
			RESULT = new ArrayList();
			CUP$parser$result = new java_cup.runtime.Symbol(39/* dim_props */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 10: // axis_spec ::= non_empty_opt expression dim_props ON
			// axis_name
		{
			QueryAxis RESULT = null;
			int bleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 4)).left;
			int bright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 4)).right;
			Boolean b = (Boolean) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 4)).value;
			int sleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 3)).left;
			int sright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 3)).right;
			Exp s = (Exp) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 3)).value;
			int dpropsleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).left;
			int dpropsright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).right;
			List dprops = (List) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).value;
			int aleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int aright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			String a = (String) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = new QueryAxis(b.booleanValue(), s, a);
			RESULT.setDimProps(dprops);
			CUP$parser$result = new java_cup.runtime.Symbol(14/* axis_spec */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 4)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 9: // axis_spec_list ::= axis_spec COMMA axis_spec_list
		{
			ArrayList RESULT = null;
			int eleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).left;
			int eright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).right;
			QueryAxis e = (QueryAxis) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 2)).value;
			int listleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int listright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			ArrayList list = (ArrayList) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			list.add(0, e);
			RESULT = list;
			CUP$parser$result = new java_cup.runtime.Symbol(
					13/* axis_spec_list */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 2)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 8: // axis_spec_list ::= axis_spec
		{
			ArrayList RESULT = null;
			int ileft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int iright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			QueryAxis i = (QueryAxis) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			RESULT = new ArrayList();
			RESULT.add(i);
			CUP$parser$result = new java_cup.runtime.Symbol(
					13/* axis_spec_list */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 7: // axis_def ::= axis_spec_list
		{
			ArrayList RESULT = null;
			int lleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int lright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			ArrayList l = (ArrayList) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			pQuery.axisDef = l;
			CUP$parser$result = new java_cup.runtime.Symbol(12/* axis_def */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 6: // axis_def ::=
		{
			ArrayList RESULT = null;
			pQuery.axisDef = new ArrayList();
			CUP$parser$result = new java_cup.runtime.Symbol(12/* axis_def */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 5: // with_clause ::= WITH formula_spec
		{
			Object RESULT = null;
			int fleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).left;
			int fright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).right;
			ArrayList f = (ArrayList) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 0)).value;
			pQuery.formulas = f;
			CUP$parser$result = new java_cup.runtime.Symbol(6/* with_clause */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 1)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 4: // with_clause ::=
		{
			Object RESULT = null;
			pQuery.formulas = new ArrayList(); /* empty */
			CUP$parser$result = new java_cup.runtime.Symbol(6/* with_clause */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 3: // sel_clause ::= DRILLTHROUGH SELECT
		{
			Object RESULT = null;

			CUP$parser$result = new java_cup.runtime.Symbol(7/* sel_clause */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 1)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 2: // sel_clause ::= SELECT
		{
			Object RESULT = null;

			// Default action for single-symbol production
			RESULT = (Object) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top)).value;
			CUP$parser$result = new java_cup.runtime.Symbol(7/* sel_clause */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 1: // mdx_statement ::= with_clause sel_clause axis_def FROM
			// cube_def slicer_def cell_prop_def
		{
			ParsedQuery RESULT = null;
			RESULT = pQuery;
			CUP$parser$result = new java_cup.runtime.Symbol(
					1/* mdx_statement */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 6)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			return CUP$parser$result;

			/* . . . . . . . . . . . . . . . . . . . . */
		case 0: // $START ::= mdx_statement EOF
		{
			Object RESULT = null;
			int start_valleft = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).left;
			int start_valright = ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).right;
			ParsedQuery start_val = (ParsedQuery) ((java_cup.runtime.Symbol) CUP$parser$stack
					.elementAt(CUP$parser$top - 1)).value;
			RESULT = start_val;
			CUP$parser$result = new java_cup.runtime.Symbol(0/* $START */,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 1)).left,
					((java_cup.runtime.Symbol) CUP$parser$stack
							.elementAt(CUP$parser$top - 0)).right, RESULT);
		}
			/* ACCEPT */
			CUP$parser$parser.done_parsing();
			return CUP$parser$result;

			/* . . . . . . */
		default:
			throw new Exception(
					"Invalid action number found in internal parse table");

		}
	}
}
