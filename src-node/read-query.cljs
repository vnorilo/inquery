(ns inquery.read-query
  (:require [cljs.nodejs :as node]))

(defn read-query [path qname]
  (let [fname (str path "/" qname ".sql")]
    (try
      (.toString
        (.readFileSync (node/require "fs") fname))
      (catch :default e
        (throw (js/Error. (str "can't find query file to load: \"" fname "\": " e)))))))

(defn make-query-map
				  ([names]
				   (make-query-map names {:path "sql"}))
				  ([names {:keys [path]}]
				   (into {}
				         (for [qname names]
				           (->> qname
				                name
				                (read-query path)
				                (vector qname))))))