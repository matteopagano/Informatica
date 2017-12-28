/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Iterator;

/**
 *
 * @author matteo
 * @param <T>
 */
public interface Visitatore<T>{
    public boolean hasNextSx();
    public boolean hasNextDx();
    public T goSx();
    public T goDx();
    public T goRadice();
}
