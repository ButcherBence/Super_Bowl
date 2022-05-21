package hu.progmatic;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<SuperBowl> datas = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("SuperBowl.txt"));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                SuperBowl superBowl = new SuperBowl(line);
                datas.add(superBowl);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<SuperBowl> data2s = new ArrayList<>(datas);
        String text = "";
        for (SuperBowl data2: data2s){
            RomaiSorszam romaiSorszam = new RomaiSorszam(data2.getSsz());
            text = romaiSorszam.getArabSsz();
            data2.setSsz(text);
        }
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("SuperBowlNew.txt"));
            bw.write("Ssz;Dátum;Győztes;Eredmény;Vesztes;Nézőszám" + "\n");
            List<SuperBowl> counterList = new ArrayList<>();
            for (SuperBowl data2 : data2s){
                counterList.add(data2);
                bw.write(data2.getSsz()+";"+data2.getDate()+
                        ";"+data2.getGyoztes()+"; ("+jatszottMeccsekSzama(counterList,data2.getGyoztes())+") ;"+data2.getEredmeny()
                        +";"+data2.getVesztes()+"; ("+jatszottMeccsekSzama(counterList,data2.getVesztes())+") ;"+data2.getNezoSzam()+"\n");
            }
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("4. feladat: " + datas.size());
        System.out.println("5. feladat: " + pontKulonsegAtlag(datas));
        legtobbNezo(datas,data2s);
    }

    public static double pontKulonsegAtlag(List<SuperBowl> datas) {
        List<Integer> pontKulonbsegs = new ArrayList<>();
        int x = 0;
        int y = 0;
        for (SuperBowl data : datas) {
            String[] result = data.getEredmeny().split("-");
            x = Integer.parseInt(result[0]);
            y = Integer.parseInt(result[1]);
            pontKulonbsegs.add(x - y);
        }
        double sum = 0;

        for (Integer pontKulonbseg : pontKulonbsegs) {
            sum += pontKulonbseg;
        }
        return Math.round((sum / datas.size()) * 10.0) / 10.0;
    }

    public static void legtobbNezo(List<SuperBowl> datas,List<SuperBowl> data2s) {


        int max = Integer.MIN_VALUE;
        for (SuperBowl data : datas) {
            if (data.getNezoSzam() > max) {
                max = data.getNezoSzam();
            }
        }
        for (SuperBowl data2 : data2s) {
            if (data2.getNezoSzam() == max) {
                String[] result = data2.getEredmeny().split("-");
                int x = Integer.parseInt(result[0]);
                int y = Integer.parseInt(result[1]);
                System.out.println("6. feladat : Legmagasabb nézőszám a döntők során: \n" +
                        "Sorszám (dátum) : " + data2.getSsz() + " " + "(" + data2.getDate() + ")" + "\n" +
                        "Győztes csapat : " + data2.getGyoztes() + ", szerzett pontok: " + x + "\n" +
                        "Vesztes csapat : " + data2.getVesztes() + ", szerzett pontok: " + y + "\n" +
                        "Helyszín : " + data2.getHelyszin() + "\n" +
                        "Város, állam  : " + data2.getVarosAllam() + "\n" +
                        "Nézőszám : " + data2.getNezoSzam());
            }
        }
    }

    public static int jatszottMeccsekSzama(List<SuperBowl> datas, String csapatnev) {
        int counter = 0;
        for (SuperBowl data : datas) {
            if (data.getGyoztes().equalsIgnoreCase(csapatnev) || data.getVesztes().equalsIgnoreCase(csapatnev)) {
                counter++;
            }
        }
        return counter;
    }
}
