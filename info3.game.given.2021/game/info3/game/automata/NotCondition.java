package info3.game.automata;

public class NotCondition implements IFunction {
	final IFunction cond;

	public NotCondition(IFunction exp) {
		cond = exp;
	}

	@Override
	public boolean eval(AutomatonListener aut) {
		return !cond.eval(aut);
	}
}
