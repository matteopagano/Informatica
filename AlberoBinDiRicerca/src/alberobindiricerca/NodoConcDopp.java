/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alberobindiricerca;

/**
 *
 * @author matteo.pagano
 * @param <T>
 */
public class NodoConcDopp<T> {
	protected T info;
	protected NodoConcDopp<T> left;
	protected NodoConcDopp<T> right;

	protected NodoConcDopp(T info, NodoConcDopp left, NodoConcDopp rigth) {
		this.info = info;
		this.left = left;
		this.right = right;
	}
}
