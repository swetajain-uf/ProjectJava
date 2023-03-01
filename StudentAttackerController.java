//Sweta Jain

package edu.ufl.cise.cs1.controllers;

import game.controllers.AttackerController;
import game.models.*;
import game.system._Maze;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.List;

public final class StudentAttackerController implements AttackerController {
	public void init(Game game) {
	}
	public void shutdown(Game game) {
	}
	public int update(Game game, long timeDue) {

		int action = 0;
		Maze m1 = game.getCurMaze();
		int numPP = m1.getNumberPowerPills(); //get how many Power Pills there are on a maze
		Actor me = game.getAttacker();
		List<Node> numPowerPill = game.getPowerPillList(); //List power pills not eaten/available
		Node toPowerPill = me.getTargetNode(numPowerPill, true); //try to get closest Power Pill
		Node toPill = me.getTargetNode(game.getPillList(), true); //closest Pill
		Defender nearestDef = (Defender) me.getTargetActor(game.getDefenders(), true); //closest Defender
		Node nearDefenLoc = nearestDef.getLocation(); //Location of closest Defender
		int goToPill = me.getNextDir(toPill, true); //direction for attacker to move towards pill
		int distFromClosestDef = nearDefenLoc.getPathDistance(me.getLocation()); //distance from closest Defender
		int lives = game.getLivesRemaining(); //num of lives left for Attacker
		if (nearestDef.isVulnerable()) { //nearest Defender is vulnerable then -
			if (distFromClosestDef <= 6) { //if the nearest Defenders location is 6 or less spaces away
				action = me.getNextDir(nearDefenLoc, nearestDef.isVulnerable()); //go towards nearest Defender
			}
			else { //if far away just go toward nearest pill
				action = goToPill;
			}
		}
		else { //if nearest Defender isnt vulnerable
			if (numPowerPill.isEmpty()) { //no more Power pills left
				if (distFromClosestDef <= 6) { //nearest defender is 6 or less spaces away - move in different direction
					action = me.getNextDir(nearDefenLoc, false);
				}
				else { //no defenders near go to nearest pill
					action = goToPill;
				}
			}
			else if (lives == 1){ //if attacker has one life left go toward power pills
				action = me.getNextDir(toPowerPill, true);
			}
			else if (numPowerPill.size() == numPP && distFromClosestDef >= 6){ //if all 4 power pills and defender are 6 or more spaces away
				action = me.getNextDir(toPowerPill, true); //apporach power pill
			}
			else {
				if (toPowerPill.getPathDistance(me.getLocation()) <= 6) { //if I am 6 or less spaces away from Power Pill go towards
					action = me.getNextDir(toPowerPill, true);
				}
				else { //not close then go to nearest pill
					action = goToPill;
				}
			}
		}
		return action;
	}
}
//TestAgent - Visual - 6780
//TestAgent - Scored: 6550.5
