package com.example.demo.entities;

@Entity @Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name= "type_mbr", discriminatorType =
DiscriminatorType.STRING,length = 3)
public abstract class Membre{ ... }