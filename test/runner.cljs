(ns inquery.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [inquery.test.core]))

(doo-tests 'inquery.test.core)