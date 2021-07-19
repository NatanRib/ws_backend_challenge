package com.natanribeiro.domain.entities.sales_order.enumerated;

public enum SalesOrderStatus {
	
	PENDING_CONFIRMATION {
		@Override
		public String toString() {
			return "Pending confirmation";
		}
	},
	CANCELED {
		@Override
		public String toString() {
			return "Canceled";
		}
	},
	CONFIRMED {
		@Override
		public String toString() {
			return "Confirmed";
		}
	};
	
	public abstract String toString();
}
