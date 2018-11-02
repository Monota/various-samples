package tokyo.monota.factory;

public class Calzone extends Pizza {
	
	private final boolean sauceInside;
	
	// ���g�̃N���X�� <Builder> �Ƃ��Ďw�肵�Ă���B
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
		
		// �q�N���X�� Builder ��Ԃ��B
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
