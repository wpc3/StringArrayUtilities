package com.zipcodewilmington;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {



        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {


        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {


        return array[array.length-1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {




        return array[array.length-2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {




        return Arrays.asList(array).contains(value);
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {

    int length = array.length;

    for (int i = 0; i < length/2; i++){//iterate through the array up to it's midpoint
        String temp = array[i];//store the element at index i in a temporary value
        array[i] = array[length - 1 - i];//Swap the element at the index i with the element at the opp end of array
        array[length - 1 - i] = temp;//Place the original element stored in temp into the position opposite i
    }
//    String reversedString = "";
//    for (int i = 0; i < array.length; i++){
//        array[i] = new StringBuilder(array[i]).reverse().toString();
//    }

        return array;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {

      for (int i=0; i<array.length; i++){
          if (!array[i].equals(array[array.length-1-i])){//check if the element at the start of the element is equal to the element at the end
              return false;
          }
      }

//    int len = array.length;
//    String strArray = array.toString();
//    for (int i =0; i < len/2; i++ ){
//        if (strArray.charAt(i) != strArray.charAt(len-1-i)){
//            return false;
//        }
//    }

        return true;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {

        String test = "abcdefghijklmnopqrstuvwxyz";

        boolean[] alphalist = new boolean[26];

        for (String str : array){
            for (int i = 0; i < str.length(); i++){
                char ch = Character.toLowerCase((str.charAt(i)));
                if('a' <= ch && ch <= 'z'){
                    alphalist[ch - 'a'] = true;
                }
            }
        }
        for (boolean value : alphalist){
            if (!value){
                return false;
            }
        }

//        String strArray = array.toString();
//        int n = array.length;
////        char c[];
//        char [] c = array.toString().toCharArray();
//
//        for (int i = 0; i< test.length(); i++){
//            char c = Character.toLowerCase(strArray.charAt(i));
//          if (c[i] != test.charAt(i)){
//              return false;
//          }
//
//        }
////
//
//        return true;
        return true;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int occurence = 0;

        for (int i = 0; i <array.length; i++){
            if (array[i].contains(value)){

                occurence++;
            }

        }

        return occurence;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
//      Arrays.asList(array).remove(valueToRemove);
    ArrayList<String> newArray = new ArrayList<>(); //creating an array list
    for(String string : array){//iterating through the array
        if (!string.equals(valueToRemove)){//check if valueToRemove is in the array
            newArray.add(string);// if string does not equal valueRemove, add string to newArray
        }
    }
    String[] rebuilt = new String[newArray.size()];//create new string array that removed valueRemove

        return newArray.toArray(rebuilt);
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {

        ArrayList<String> newArray = new ArrayList<>();

        newArray.add(array[0]);//taking first element of the string array

        for(int i = 1; i < array.length; i++){
            if(!array[i-1].equals(array[i])){//if previous index and current index are the same
                newArray.add(array[i]);//adding indexes that arent the same
            }
        }



//    int i = 0;//Initialize start pointer
//    int j=0;//Initialize stop pointer
//    String strArray = array.toString();
//
//        String newElements = "";//Initialize an empty string for new elements
//
//        //Iterate string using j pointer
//        while (j < strArray.length()){
//            if (strArray.charAt(i) == strArray.charAt(j)){
//                j++;
//            }
//            else if (strArray.charAt(j) != strArray.charAt(i) || j == strArray.length()-1){
//                newElements += strArray.charAt(i);
//                i = j;
//                j++;
//            }
//        }
//    newElements += strArray.charAt(j-1);
//    String[] arrayOFNewElements = newElements.split("");


        return newArray.toArray(new String[0]);
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {

    ArrayList<String> test = new ArrayList<>();
    StringBuilder chars = new StringBuilder(array[0]);//Initiates a StringBuilder that holds the first element in the array.

    for(int i =1; i < array.length; i++){
        if (array[i].equals(array[i-1])){//check if previous index equals current index
            chars.append(array[i]);//adds duplicate element to string builder
        }
        else {
            test.add(chars.toString());//add the string we made to the ArrayList
            chars = new StringBuilder(array[i]);//resets the stringBuilder for next sequence
        }
    }
    test.add(chars.toString());//Add the last sequence after loop ends

        return test.toArray(test.toArray(new String[0]));//Convert ArrayList to String array
    }


}
