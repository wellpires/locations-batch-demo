package com.locations.batch.locationsbatch.enums;

import java.util.Objects;

public enum QualityStatus {

	QUALIFIED(7.0, 10.0), IMPROVING(5.0, 6.0), UNQUALIFIED(4.0, 0.0);

	private QualityStatus(double minimunValue, double maximumValue) {
	}

	/**
	 * <p>
	 * QUALIFIED = mais de 6.0;
	 * </p>
	 * <p>
	 * IMPROVING = acima de 4.0 e abaixo ou igual 6.0
	 * </p>
	 * <p>
	 * UNQUALIFIED = abaixo ou igual 4.0;
	 * </p>
	 * 
	 * @param evaluation
	 * @return QualityStatus
	 */
	public static QualityStatus defineQuality(Double evaluation) {

		if (Objects.isNull(evaluation)) {
			throw new IllegalArgumentException("Evaluation cannot be null!");
		}

		QualityStatus quality = QUALIFIED;
		if (evaluation > 4.0 && evaluation <= 6.0) {
			quality = IMPROVING;
		} else if (evaluation <= 4.0) {
			quality = UNQUALIFIED;
		}

		return quality;
	}

}
