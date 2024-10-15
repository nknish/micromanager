# _micromanager_

**a (wip) text-based game where you manage a microgrid!**

## format

- command line, interactive, rpg style
- all gameplay is done thru typing. no mouse, no buttons, no nonsense

## setting

- small isolated town (you pick the name)
   steady population
- former power source: evil inc. coal plant
  - reliable, fairly cheap
  - still connected via transmission line
- current power sources: microgrid tech!
  - a few mid-scale solar plants just outside town
  - one decent-sized wind operation
  - lots of houses already have solar panels!
  - some heat pumps? some batteries?
  - still get about 25% energy from coal plant for cost/stability

## where you come in!

- you’re a brand new grid administrator!
  - you have 1 year to prove yourself on a few key metrics
- you'll play for 12 months - 1 scenario per month
  - each scenario is a decision point with different outcomes
- the old grid is solid, but you want to up its game
  - your goal is to make improvements, so at the end of the year, the people are happy!

## metrics of success

- climate score — protect the planet!
  - clean energy is better
  - energy efficiency (less energy) is better
- consumer score - make people happy!
  - keep energy costs low (this is the big one)
  - make nimbys happy (?)
  - avoid blackouts! at all costs!
- civic score — the grid is a good citizen!
  - please the local gov by supporting their ordinances
  - help out small businesses (chamber of commerce vibe)
  - save the endangered chipmunk (environmental group)
- MONEYMONEYMONEY - if you run out you have to borrow money (ruining civic score)
  - sell energy to customers
  - buy back from rooftop solar
  - buy energy from evil coal plant
  - invest in infrastructure repairs
  - federal grants
  - rainy day money to rebuild after a disaster

## possible scenarios

- the seasons (shifting demand and supply of energy)
- 1 or 2 natural disasters, heat wave/storm
- aging infrastructure repair/replace (nimbys in the way)
- long term planning—start a project with rewards far in the future
- new exciting technology! invest or avoid?
- government (federal grants, local restrictions)
- connect the grid to a neighboring town

## the backend

- what goes on behind the scenes
  - each decision should spark changes in the various scores and cash
  - each possible choice has odds (d&d style) and severity of outcomes
  - at the end of 12 months, you can get fired (maybe)
  - in a future version, each decision can have a bearing on future scenarios
- what you control (through various scenarios)
  - sale of energy to consumers
  - buying from local coal plant
  - buying energy off of rooftop solar folks
  - brownouts?
  - infrastructure repairs

## swe goals

- polished, finished product
- downloadable off of github
  - executable in terminal
- do interesting backend calculations
