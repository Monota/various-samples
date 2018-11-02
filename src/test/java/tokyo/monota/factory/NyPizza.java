package tokyo.monota.factory;

import java.util.Objects;

public class NyPizza extends Pizza {
	
	public enum Size {SMALL, MEDIUM, LARGE};
	
	private final Size size;
	
	// ���g�̃N���X�� <Builder> �Ƃ��Ďw�肵�Ă���B
	public static class Builder extends Pizza.Builder<Builder> {
		
		private final Size size;
		
		public Builder(Size size) {
			this.size = Objects.requireNonNull(size);
		}
		
		@Override
		public NyPizza build() {
			return new NyPizza(this);
		}
		
		// �q�N���X�� Builder ��Ԃ��B
		@Override
		protected Builder self() {
			return this;
		}
	}
	
	private NyPizza(Builder builder) {
		super(builder);
		size = builder.size;
	}
	
	public Size getSize() {
		return this.size;
	}
}
