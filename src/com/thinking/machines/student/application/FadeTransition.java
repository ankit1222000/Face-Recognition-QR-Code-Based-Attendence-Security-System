/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.util.Duration;

public class FadeTransition 
{
 public static void applyFadeTransition(Node node,Duration duration,EventHandler<ActionEvent> event)
 {
 javafx.animation.FadeTransition fadeIN = new javafx.animation.FadeTransition(duration,node);
 fadeIN.setCycleCount(1);
 fadeIN.setFromValue(0.2);
 fadeIN.setToValue(1);
 fadeIN.setAutoReverse(true);
 fadeIN.setOnFinished(event);
 System.out.println("Fade In hua");
 javafx.animation.FadeTransition fadeOut= new javafx.animation.FadeTransition(duration,node);
 fadeOut.setCycleCount(1);
 fadeOut.setFromValue(1);
 fadeOut.setToValue(0.2);
 fadeOut.setAutoReverse(true);
  System.out.println("Fade out hua");
 fadeOut.play();
 fadeOut.setOnFinished((e)->{
 fadeIN.play();
 });
 
 
 }


    
}
