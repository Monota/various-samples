package tokyo.monota.factory;

public class Calzone extends Pizza {
	
	private final boolean sauceInside;
	
	// 自身のクラスを <Builder> として指定している。
	public static class Builder extends Pizza.Builder<Builder> {
		
		private boolean sauceInside = false;
		
		public Builder sauseInside() {
			sauceInside = true;
			return this;
		}
		
		@Override
		public Calzone build() {
			return new Calzone(this);
		}
		
		// 子クラスの Builder を返す。
		@Override
		protected Builder self() {
			return this;
		}
	}

	private Calzone(Builder builder) {
		super(builder);
		sauceInside = builder.sauceInside;
	}
	
	public boolean isSauceInside() {
		return this.sauceInside;
	}
}
