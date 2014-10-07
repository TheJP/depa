/**
 * StateMachine
 * @author JP
 *
 */
public class StateMachine {

	private double m = 0;
	private double quo = 10;
	private int exp = 0;
	private int exp_sign = 1;
	private final State _S0 = new S0();
	private final State _S1 = new S1();
	private final State _S2 = new S2();
	private final State _S3 = new S3();
	private final State _S4 = new S4();
	private final State _S5 = new S5();
	private final State _S6 = new S6();
	private State state = _S0;

	private StateMachine(){ }

	/**
	 * Handle the next char in the SM
	 * @param next
	 */
	private void read(char next){
		if(Character.isDigit(next)){
			state.handleDigit(Character.getNumericValue(next));
		}
		switch(Character.toLowerCase(next)){
			case '.': state.handlePoint(); break;
			case 'e': state.handleE(); break;
			case '+': state.handleSign(1); break;
			case '-': state.handleSign(-1); break;
		}
	}

	/**
	 * Thread safe implementation
	 * (What if parse() was not static and multiple threads accessed it simultaneously)
	 * @param input String to parse
	 * @return Parsed double
	 */
	public static double parse(String input){
		StateMachine sm = new StateMachine();
		int len = input.length();
		for(int pos = 0; pos < len; ++pos){
			sm.read(input.charAt(pos));
		}
		if(!(sm.state instanceof AcceptedState)){ throw new IllegalStateException(); }
		return sm.m * Math.pow(10, sm.exp_sign * sm.exp);
	}

	/**
	 * Tests
	 * @param args
	 */
	public static void main(String[] args) {
		//Legal states
		System.out.println(StateMachine.parse("1.33"));
		System.out.println(StateMachine.parse("0.4e10"));
		System.out.println(StateMachine.parse(".3"));
		System.out.println(StateMachine.parse(".4E+5"));
		System.out.println(StateMachine.parse("5.E+5"));
		System.out.println(StateMachine.parse("4e-3"));
		//Illegal States
		try{ StateMachine.parse("1..33"); System.out.println("baaa"); } catch(IllegalStateException e){ System.out.println("check"); }
		try{ StateMachine.parse("..33"); System.out.println("baaa"); } catch(IllegalStateException e){ System.out.println("check"); }
		try{ StateMachine.parse("e15"); System.out.println("baaa"); } catch(IllegalStateException e){ System.out.println("check"); }
		try{ StateMachine.parse("510"); System.out.println("baaa"); } catch(IllegalStateException e){ System.out.println("check"); } //per definition
	}

	interface State {
		void handleDigit(int digit);
		void handlePoint();
		void handleE();
		void handleSign(int sign);
	}
	abstract class StateBase implements State {
		@Override public void handleDigit(int digit){ throw new IllegalStateException(); }
		@Override public void handlePoint(){ throw new IllegalStateException(); }
		@Override public void handleE(){ throw new IllegalStateException(); }
		@Override public void handleSign(int sign){ throw new IllegalStateException(); }
	}
	abstract class AcceptedState extends StateBase {}
	class S0 extends StateBase {
		@Override public void handleDigit(int digit) { m = digit; state = _S1; }
		@Override public void handlePoint() { state = _S2; }
	}
	class S1 extends StateBase {
		@Override public void handleDigit(int digit) { m = (m*10) + digit; }
		@Override public void handlePoint() { state = _S3; }
		@Override public void handleE() { state = _S4; }
	}
	class S2 extends StateBase {
		@Override public void handleDigit(int digit) { m += (double)digit / quo; quo *= 10; state = _S3; }
	}
	class S3 extends AcceptedState {
		@Override public void handleDigit(int digit) { m += (double)digit / quo; quo *= 10; }
		@Override public void handleE() { state = _S4; }
	}
	class S4 extends StateBase {
		@Override public void handleDigit(int digit) { exp = digit; state = _S6; }
		@Override public void handleSign(int sign) { exp_sign = sign; state = _S5; }
	}
	class S5 extends StateBase {
		@Override public void handleDigit(int digit) { exp = (exp*10) + digit; state = _S6; }
	}
	class S6 extends AcceptedState {
		@Override public void handleDigit(int digit) { exp = (exp*10) + digit; }
	}
}
