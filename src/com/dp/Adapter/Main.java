package com.dp.Adapter;

interface OutdoorGames {
    void largeArea();
    void ballGame();
}

class Football implements OutdoorGames{
    @Override
    public void largeArea() {
        System.out.println("Can be played in large area.");
    }
    @Override
    public void ballGame() {
        System.out.println("Requires ball (football)");
    }
}

interface IndoorGames {
    void smallArea();
    void boardGame();
}

class Chess implements IndoorGames {
    @Override
    public void smallArea() {
        System.out.println("Can be played in small area.");
    }
    @Override
    public void boardGame() {
        System.out.println("Requires chess board");
    }
}

class ChessAdapter implements OutdoorGames{
    private Chess chess;
    public ChessAdapter(Chess chess) {
        this.chess = chess;
    }
    @Override
    public void largeArea() {
        chess.smallArea();
    }
    @Override
    public void ballGame() {
        chess.boardGame();
    }
}

public class Main {
    public static void main(String[] args) {
        OutdoorGames og = new Football();
        OutdoorGames ig = new ChessAdapter(new Chess());  // implementing adapter pattern
        System.out.println("... outdoorGame 'Football' ...");
        og.largeArea();
        og.ballGame();
        System.out.println("... indoorGame 'chess' ...");
        ig.largeArea();
        ig.ballGame();
    }
}

