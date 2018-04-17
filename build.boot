(set-env!
  :source-paths   #{"src"}
  :dependencies '[[org.clojure/clojure  "1.9.0-RC1" :scope "provided"]
                  [boot/core            "2.7.2"     :scope "provided"]
                  [entranceplus/bootlaces     "0.1.14"    :scope "test"]
                  [cheshire             "5.6.3"]])

(require '[adzerk.bootlaces :refer :all])

(def +version+ "0.0.1")

(bootlaces! +version+)

(task-options!
 pom  {:project     'entranceplus/boot-shadow-cljs
       :version     +version+
       :description "Boot task to compile clojurescript via shadow-cljs"
       :url         "https://github.com/shakdwipeea/boot-shadow-cljs"
       :scm         {:url "https://github.com/shakdwipeea/boot-shadow-cljs"}
       :license     {"Eclipse Public License" "http://www.eclipse.org/legal/epl-v10.html"}})

(deftask build []
  (comp (pom) (jar) (install)))

;;; todo
;; * modify bootlaces to set gpg-sign to false
;; * change dep group of bootlaces in *all* projects
;; * change dep group of boot-shadow-cljs in voidwalker



(deftask publish []
  (comp
   (build-jar)
   (push-release)))
