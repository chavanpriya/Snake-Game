package com.piyu;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Priya on 3/31/2018.
 */
public class Snake extends KeyAdapter implements Serializable{
    private LinkedList<Coordinate> _coordinateList = new LinkedList<>();
    private Direction _direction;

    public Snake(LinkedList<Coordinate> _coordinateList, Direction _direction) {
        this._coordinateList = _coordinateList;
        this._direction = _direction;
    }

    public List<Coordinate> getCoordinateList() {
        return _coordinateList;
    }

    public void increaseSize()
    {
        Coordinate tail = move();
        _coordinateList.addLast(tail);
    }

    public Coordinate move() {
        Coordinate head = _coordinateList.getFirst();
        Coordinate newHead;
        Coordinate tail = null;

        switch (_direction) {
            case RIGHT:
                newHead = new Coordinate(head.get_row(),head.get_column()+1);
                tail = _coordinateList.removeLast();
                _coordinateList.addFirst(newHead);
                break;

            case LEFT:
                newHead = new Coordinate(head.get_row(), head.get_column() -1);
                tail = _coordinateList.removeLast();
                _coordinateList.addFirst(newHead);
                break;

            case UP:
                newHead = new Coordinate(head.get_row()-1, head.get_column());
                tail = _coordinateList.removeLast();
                _coordinateList.addFirst(newHead);
                break;

            case DOWN:
                newHead = new Coordinate(head.get_row()+1, head.get_column());
                tail = _coordinateList.removeLast();
                _coordinateList.addFirst(newHead);
                break;
        }
        return tail;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                if(_direction != Direction.RIGHT){
                    _direction = Direction.LEFT;
                }
                break;

            case KeyEvent.VK_RIGHT:
                if(_direction != Direction.LEFT){
                    _direction = Direction.RIGHT;
                }
                break;

            case KeyEvent.VK_UP:
                if(_direction != Direction.DOWN){
                    _direction = Direction.UP;
                }
                break;

            case KeyEvent.VK_DOWN:
                if(_direction != Direction.UP){
                    _direction = Direction.DOWN;
                }
                break;
        }
    }
}
