# Arch Unit Example

This project contains some examples of the use of Arch Unit to force arch decisions.

#### Force Boundaries

In order to develop packages that represent components without cross boundaries accessing other components,
some tests were defines to just allow component external dependencies comunicate using services and not call repositories directly.  