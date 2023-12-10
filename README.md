# SWN
This project is used for creating player characters and generating random worlds, characters and scenarios for the Stars Without Number role-playing game.

## Design

This project makes a lot of use of springs features to make it quick and easy to generate text that relies on dice rolls and random chance to be generated. This text is generated from a collection of properties.

There are three main types of properties. They are all defined in slightly different ways in the text files. A property supplier will be used to select a random property from its collection and display it. The property supplier should be able to handle any combination of properties.

The three types of properties are:

### Base Properties

These are basic strings. Each will have a range of values that they cover (although that range usually just covers one number). They will return a string of the property name and their associated string. The property name is usually derived from the class name of the property itself.

### Property supplier properties PSP

These contain a link to another file which should be selected randomly from. The resulting string will contain the original propery name + the value from the further roll. For example when the beasts traits are rolled it has to first roll to see if it is predator, prey or a scavenger, and then a further roll has to be made to determine its traits from a sublist.

### Display properties property DPP

This contains a link to a number of further files. These files are then loaded and the results from them are combined together to return the correct string. For example on the beasts weapon trait, if poison is rolled, a further 3 rolls are needed to be made to determin the effect, onset and duration.


For most cases, the base properties are sufficient.

To add a new generation item, you have to create a new package in the generator with the name of the item you want to generate [X]. Then add a XCreator class which should contain a XDisplayProperties genericised with an XPropertySupplier. The XPropertySupplier should contain the path to the desired file. Then for every property you want to add to that generate then you will have to add a subclass of the XPropertySupplier and create a file with the same name in the folder specified in the XPropertySupplier. This should have a list of the desired properties.

Code is deployed automatically to a vercel instance.
