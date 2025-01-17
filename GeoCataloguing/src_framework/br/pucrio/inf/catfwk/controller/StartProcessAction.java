/**
 * 
 */
package br.pucrio.inf.catfwk.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import br.pucrio.inf.catfwk.view.CurrentWsp;

/**
 * @author Luiz Leme
 * @alias StartProcessAction*/
public class StartProcessAction extends AbstractAction {

	private static final long serialVersionUID = 795742239077801363L;
	private CurrentWsp currentWsp;

	/**
	 * @param currentWsp
	 */
	public StartProcessAction(CurrentWsp currentWsp) {
		this.currentWsp = currentWsp;
	}

	public void actionPerformed(ActionEvent e) {
		currentWsp.startProcess();
	}
}