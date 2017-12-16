import java.util.*;

public class Ocean {

    private List<Boat>   boats;
    private int[][]      board;
    private List<String> boatTypes;


    public Ocean() {

        boats = new ArrayList<Boat>();
        board = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = -1; //the index of the boats in arraylist boats will represent int in board
            }
        }
        boatTypes = new ArrayList<String>(Arrays.asList("Aircraft Carrier", "Battleship", "Submarine", "Cruiser", "Destroyer"));
    }

    public void placeBoat(String t, Position p, String o) throws Exception {
        Boat temp = new Boat(t, p, o);

        if (p.rowIndex() < 0 || p.columnIndex() < 0) {
            throw new Exception("Out-of-Board");
        } else {
            if (o.equals("vertical")) { //case accounted for in boat constructor
                if ((temp.size() + p.rowIndex()) > 10) {
                    throw new Exception("Out-of-Board");
                } else {
                    for (int i = p.rowIndex(); i < (p.rowIndex() + temp.size()); i++) {
                        if (board[i][p.columnIndex()] != -1) {
                            throw new Exception("Overlap");
                        }
                    }
                    for (int i = p.rowIndex(); i < (p.rowIndex() + temp.size()); i++) {
                        board[i][p.columnIndex()] = boats.size();
                    }

                }
            } else { //horizontal
                if ((temp.size() + p.columnIndex()) > 10) {
                    throw new Exception("Out-of-Board");
                } else {
                    for (int i = p.columnIndex(); i < (p.columnIndex() + temp.size()); i++) {
                        if (board[p.rowIndex()][i] != -1) {
                            throw new Exception("Overlap");
                        }
                    }
                    for (int i = p.columnIndex(); i < (p.columnIndex() + temp.size()); i++) {
                        board[p.rowIndex()][i] = boats.size();
                    }

                }

            }
        }


        boats.add(new Boat(t, p, o));
    }


    public void shootAt(Position pos) {
        if (board[pos.rowIndex()][pos.columnIndex()] != -1) {
            boats.get(board[pos.rowIndex()][pos.columnIndex()]).hit(pos);
        }
    }

    public boolean hit(Position pos) {

        if (board[pos.rowIndex()][pos.columnIndex()] != -1) {
            return boats.get(board[pos.rowIndex()][pos.columnIndex()]).isHit(pos);
        } else {
            return false;
        }
    }

    public char boatInitial(Position pos) {
        if (board[pos.rowIndex()][pos.columnIndex()] != -1) {
            return boats.get(board[pos.rowIndex()][pos.columnIndex()]).abbreviation();
        } else {
            return ' ';
        }

    }

    public String boatName(Position pos) {
        if (board[pos.rowIndex()][pos.columnIndex()] != -1) {
            return boats.get(board[pos.rowIndex()][pos.columnIndex()]).name();
        } else {
            return "";
        }
    }

    public boolean sunk(Position pos) {
        if (board[pos.rowIndex()][pos.columnIndex()] != -1) {
            return boats.get(board[pos.rowIndex()][pos.columnIndex()]).sunk();
        } else {
            return false;
        }

    }

    public boolean allSunk() {
        for (Boat b : boats) {
            if (!b.sunk()) {
                return false;
            }
        }
        return true;
    }


    public void placeAllBoats() {
        while (boatTypes.size() != 0) {
            String orientation;
            int row = (int) (Math.random()*10);;
            int col = (int) (Math.random()*10);
            boolean correct = true;
            if (Math.random() < 0.5) {
                orientation="horizontal";
            }else{
                orientation="vertical";
            }           

            try {
                placeBoat(boatTypes.get(0),new Position(row,col),orientation);
            } catch (Exception e) {
                    correct = false;
            }
            if(correct)
                boatTypes.remove(0);
        }
    }
    
     public String toString() {
        String res = "";
        for (int[] a : board) {
            for (int b : a) {
                res += (b + " ");
            }
            res += "\n";
        }
        return res;
    }


}
