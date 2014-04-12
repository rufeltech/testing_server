package ru.eltech.csa.siths.service.base;

public abstract class AbstractPaginationService {
	
	public static enum Direction {
		LEFT_TO_RIGHT,
		RIGHT_TO_LEFT
	}

	protected byte pagesToDisplay;
	protected byte fromPageNumberToBegin;
	protected Direction direction;

	public AbstractPaginationService(byte pagesToDisplay, byte fromPageNumberToBegin, Direction direction) {
		this.pagesToDisplay = pagesToDisplay;
		this.fromPageNumberToBegin = fromPageNumberToBegin;
		this.direction = direction;
	}

	public AbstractPaginationService(byte pagesToDisplay, byte fromPageNumberToBegin) {
		this(pagesToDisplay, fromPageNumberToBegin, Direction.LEFT_TO_RIGHT);
	}

	public AbstractPaginationService(byte pagesToDisplay) {
		this(pagesToDisplay, (byte)1);
	}

	public AbstractPaginationService() {
		this((byte)10);
	}

	public byte getPagesToDisplay() {
		return this.pagesToDisplay;
	}

	public void setPagesToDisplay(byte pagesToDisplay) {
		this.pagesToDisplay = pagesToDisplay;
	}

	public byte getfromPageNumberToBegin() {
		return this.pagesToDisplay;
	}

	public void setfromPageNumberToBegin(byte fromPageNumberToBegin) {
		this.fromPageNumberToBegin = fromPageNumberToBegin;
	}

	public Direction getDirection() {
		return this.direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
}