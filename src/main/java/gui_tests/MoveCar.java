package gui_tests;

import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;

import java.util.ArrayList;

/**
 *  Simple test setup, to easily move cars around the Board
 */
public class MoveCar {

    private static final int NUM_FIELDS = 24;
    private static final int NUM_PLAYERS = 4;

    public static void main(String[] args) {

        // Construct fields
        ArrayList<String> fieldNames = new ArrayList<>();
        ArrayList<GUI_Field> fields = new ArrayList<>();
        for( int i=0; i<NUM_FIELDS; i++){
            GUI_Field field = new GUI_Street();
            field.setTitle("Field " + i);
            fieldNames.add("Field " + i);
            fields.add(field);
        }

        GUI gui = new GUI(fields.toArray(new GUI_Field[0]));

        // Setup player
        ArrayList<GUI_Player> players = new ArrayList<>();
        ArrayList<String> playerNames = new ArrayList<>();
        for( int i=0; i<NUM_PLAYERS; i++ ) {
            String playerName = "Player " + (i+1);
            playerNames.add(playerName);

            GUI_Player player = new GUI_Player(playerName);
            players.add(player);

            gui.addPlayer(player);
        }

        while(true) {
            String button = gui.getUserButtonPressed("Choose player to move",
                playerNames.toArray(new String[0]));

            GUI_Player playerToMove = players.get( playerNames.indexOf(button) );

            String targetFieldName = gui.getUserSelection("Choose field to move to",
                    fieldNames.toArray(new String[0])
            );

            /*for( GUI_Field field : gui.getFields() )
                field.setCar(playerToMove, false);
            gui.getFields()[fieldNames.indexOf(targetFieldName)].setCar(playerToMove, true);*/

            playerToMove.getCar().setPosition(gui.getFields()[fieldNames.indexOf(targetFieldName)]);
        }

    }

}
