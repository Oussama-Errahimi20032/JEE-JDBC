/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import static beans.Test.load;
import static beans.Test.save;

/**
 *
 * @author oussama
 */
public class Main {
    public static void main(String[] args) {
        save(new Site("Rommani"));
        save(new Site("Rabat"));
        load();
    }
}
