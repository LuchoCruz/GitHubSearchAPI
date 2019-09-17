Feature: GitHub Search Repositories API

  Scenario Outline:  User filters by author
  Given       user can make requests to "search/repositories"
  When        user sends request filling parameter q with values "<author>"
  Then        service returns a list of repositories
  Examples:
    | author   |
    | LuchoCruz|

  Scenario Outline:   User filters by author, sorts using different options
    Given       user can make requests to "search/repositories"
    When        user sends request filling parameter q with values for author: "<author>" and sort: "<sort>"
    Then        service returns a list of repositories
    Examples:
      | author   | sort                  |
      | LuchoCruz| stars                 |
      #| LuchoCruz| forks                 |
      #| LuchoCruz| help-wanted-issues    |
      #| LuchoCruz| updated               |
      #| LuchoCruz|                       |

  Scenario Outline:   User filters by author, sorts using different options and indicates results per page to be shown
    Given       user can make requests to "search/repositories"
    When        user sends request filling parameter q with values for author: "<author>", sort: "<sort>" and per_page: "<per_page>"
    Then        service returns a list of repositories showing at least "<per_page>" items
    Examples:
      | author   | sort                  | per_page |
      #| LuchoCruz| stars                 | 0        |
      | LuchoCruz| stars                 | 1        |
      | LuchoCruz| forks                 | 2        |
      #| LuchoCruz| help-wanted-issues    | 3        |
      #| LuchoCruz| updated               | 4        |
      #| LuchoCruz|                       | 5        |

  Scenario Outline:   User filters by author, indicates only 1 result per page and asks for page 3 of results
    Given       user can make requests to "search/repositories"
    When        user sends request filling parameter q with values for author: "<author>", per_page: "<per_page>" and page: "<page>"
    Then        service returns a list of repositories
    Examples:
      | author   | per_page | page  |
      | LuchoCruz| 1        | 3     |

  Scenario Outline:   User filters by author and repo but has no authorization to see it
    Given       user can make requests to "search/repositories"
    When        user sends request filling parameter q with values "<repo>"
    Then        service returns repo not found or not accessible
    Examples:
      | repo                  |
      | LuchoCruz/NonExistent |

