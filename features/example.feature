Feature: Getting started

  Scenario Outline: define the node <scenario>
    Given from the file 'hello.json'
    When define the 'name' node of 'person.name'
    Then leaf 'first' of the node 'name' is '<first>'
    And leaf 'last' of the node 'name' is '<last>'

    Examples:
    | scenario | first | last   |
    | s1       | Mike  | Tision |
    | s2       | Mike  | Tision |