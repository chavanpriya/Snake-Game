package com.piyu;

import java.io.Serializable;

/**
 * Created by Priya on 3/31/2018.
 */
public class Coordinate implements Serializable {
    private int _row;
    private int _column;

    public Coordinate(int _row, int _column) {
        this._row = _row;
        this._column = _column;
    }

    public int get_row() {
        return _row;
    }

    public void set_row(int _row) {
        this._row = _row;
    }

    public int get_column() {
        return _column;
    }

    public void set_column(int _column) {
        this._column = _column;
    }
}
