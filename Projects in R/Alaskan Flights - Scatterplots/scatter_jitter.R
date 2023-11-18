library(ggplot2)
library(nycflights13)
library(dplyr)
library(knitr)
library(tidyverse)


alaska_flights <- flights %>% 
  filter(carrier == "AS")

ggplot(data = alaska_flights, mapping = aes(x = dep_delay, y = arr_delay)) + 
  geom_jitter(width = 30, height = 30)
ggsave("scatter_jitter.pdf")
