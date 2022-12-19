package sem6;


/*
Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы.
Реализовать в java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации
и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map.
Например: “Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
Далее нужно запросить минимальные значения для указанных критериев -
сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
*/

import java.util.*;

public class Notebooks {
    
    private String name;
    private int ramVolume;
    private int hddVolume;
    private String system;
    private Double sizeMonitor;
    private String color;
    
    public Notebooks (String name, int ramVolume, int hddVolume, String system, Double sizeMonitor, String color) {
        this.name = name;
        this.ramVolume = ramVolume;
        this.hddVolume = hddVolume;
        this.color = color;
        this.system = system;
        this.sizeMonitor = sizeMonitor;
    }
    
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    
    public int getRamVolume() {
        return ramVolume;
    }
    public void setRamVolume(int ramVolume) {
        this.ramVolume = ramVolume;
    }
    

    public int getHddVolume() {
        return hddVolume;
    }
    public void setHddVolume(int hddVolume) {
        this.hddVolume = hddVolume;
    }


    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }


    public String getSystem() {
        return system;
    }
    public void setSystem(String system) {
        this.system = system;
    }


    public Double getSizeMonitor() {
        return sizeMonitor;
    }
    public void setSizeMonitor(Double sizeMonitor) {
        this.sizeMonitor = sizeMonitor;
    }
    
        
    @Override
    public String toString () {
        return  "Ноутбук " + name +
                "\nОперативная память, Гб: " + ramVolume +
                "\nЖесткий диск, Гб: " + hddVolume +
                "\nОС: " + system +
                "\nДиагональ монитора, дюйм: " + sizeMonitor +
                "\nЦвет: " + color + "\n\n";
    }
    
    @Override
    public boolean equals (Object value) {
        if (this == value) {
            return true;
        }
        if (!(value instanceof Notebooks)) {
            return false;
        }
        Notebooks note = (Notebooks) value;
        if (this.getName().equals(note.getName())
        && this.getRamVolume()==note.getRamVolume()
        && this.getHddVolume()==note.getHddVolume()
        && this.getSizeMonitor().equals(note.getSizeMonitor())) {
            return true;
        }
        return false;
    }
}