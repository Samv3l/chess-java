package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int row, int column) {
		if (row < 1 && column < 1) {
			throw new BoardException("Erro a criar o tabuleiro: tem de ter mais de uma linha e coluna");
		}
		this.rows = row;
		this.columns = column;
		pieces = new Piece[row][column];
	}

	public int getRow() {
		return rows;
	}

	public int getColumn() {
		return columns;
	}

	public Piece piece(int row, int column) {
		if (!positionExists(row, column)) {
			throw new BoardException("Posição fora do tabuleiro");
		}
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Posição fora do tabuleiro");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("Já existe uma peça nessa posição" + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Posição fora do tabuleiro");
		}
		return piece(position) != null;
	}
	
}
