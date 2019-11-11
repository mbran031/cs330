#! /usr/bin/env python3

# Programmer : Thomas J. Kennedy

# Note how I did not translate my
# utilities library that I wrote
# for the C++ and Java versions

# import utilities.Utilities;

from shapes import *

import pickle
import sys
import json

PROGRAM_HEADING = ["Objects & Inheritance: 2-D Shapes",
                   "Thomas J. Kennedy"]  # Program Title


def main():
    """
    The main function. In practice I could name this
    anything. The name main was selected purely
    out of familiarity.

    The "if __name__" line below determines what runs
    """

    if len(sys.argv) < 2:
        print("No input file provided.")
        print("Usage: {:} input_file".format(*sys.argv))
        exit(1)

    shapes_filename = sys.argv[1]

    # Print Program Heading
    print("-" * 80)

    for line in PROGRAM_HEADING:
        print("{:^80}".format(line))

    print("-" * 80)

    # Examine the ShapeFactory
    print("~" * 38)
    print("{:^38}".format("Available Shapes"))
    print("~" * 38)

    # List the available shapes
    print(ShapeFactory.list_known())
    print("-" * 38)
    print("{:>2} shapes available.".format(ShapeFactory.number_known()))
    print()

    # makeCircle = lambda attribs : Circle(**attribs)

    # print(ShapeFactory.create_from_dictionary("Circle", {"radius": 4}))

    # The list needs to be intialzed outside the "with" closure
    shapes = []  # Create an empty list (prefer `[]` over `list()`)

    # shapes_in = open(shapes_filename, "r")
    with open(shapes_filename, "r") as shapes_in:
        for line in shapes_in:

            line = line.strip()  # Strip leading/trailing whitespace
            # print(line)

            line = line.split(";")  # Split on ";"
            # print(line)

            name, values = line  # Unpack the list
            # print(name)
            # print(values)
            values = values.strip()

            # print(values)
            values = json.loads(values)
            # print(values)

            shapes.append(ShapeFactory.create_from_dictionary(name, values))

    # Remove all `None` entries with a list comprehension
    shapes = [s for s in shapes if s is not None]

    # Print all the shapes
    print("~" * 38)
    print("{:^38}".format("Display All Shapes"))
    print("~" * 38)

    for s in shapes:
        print(s)

    # for s in shapes:
    #     print(pickle.dumps(s, 0))

    # for s in shapes:
    #     name = s.__dict__["_name"]
    #     attribs = {key: s.__dict__[key] for key in s.__dict__ if key != "_name"}
    #     print(attribs)


if __name__ == "__main__":
    try:
        main()
    except FileNotFoundError as e:
        print(e)
