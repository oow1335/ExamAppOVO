
package edu.saintjoe.cs.brianc.examtwo;

//imports bring in code that impliments
import com.google.devtools.simple.runtime.components.Component;
import com.google.devtools.simple.runtime.components.HandlesEventDispatching;
import com.google.devtools.simple.runtime.components.android.Form;

import com.google.devtools.simple.runtime.components.android.Button;
import com.google.devtools.simple.runtime.components.android.Label;
import com.google.devtools.simple.runtime.components.android.HorizontalArrangement;
import com.google.devtools.simple.runtime.components.android.TextBox;


import com.google.devtools.simple.runtime.events.EventDispatcher;

//give app a class
public class ExamActivity extends Form implements HandlesEventDispatching {
	
	// The containers which organize the application screen
	private HorizontalArrangement line1, line2, line3, line4, line5;
//	components
	private Button incButton;
	private Label resultLabel;
	private Label promptLabel;
	private TextBox inputBox;
	private Label outputLabel;
	int temp;
	
// takes the place of main
 void $define() {
 	//sets background color
     this.BackgroundColor(COLOR_WHITE);
     
     line1 = new HorizontalArrangement(this);
     line2 = new HorizontalArrangement(this);
     line3 = new HorizontalArrangement(this);
     line4 = new HorizontalArrangement(this);

     
     promptLabel = new Label(line1, "Enter a number:");
     inputBox = new TextBox(line1);
     inputBox.NumbersOnly(true);
   
     incButton = new Button(line2,"Double It:"); 
     
     resultLabel = new Label(line3,"");
     
     outputLabel = new Label(line4, "");
 // Lets us know when the button is being clicked
     EventDispatcher.registerEventForDelegation(this, "ButtonClick", "Click");
    
 } 
 @Override
// is called when the application is running
 public boolean dispatchEvent(Component component, String id, String eventName,
         Object[] args) {
 	// event handler
	    if (component.equals(incButton) && eventName.equals("Click")){
	    	temp = Integer.parseInt(inputBox.Text());
	    	temp *= 2;
	    	resultLabel.Text(String.valueOf(temp));
	        return true;
	     } 
	    
	    if (component.equals(resultLabel) && eventName.equals("Click")) {
	    	outputLabel.Text("You pushed me!!");
	    	return true;
	    }
    return true;
	} 
} 
