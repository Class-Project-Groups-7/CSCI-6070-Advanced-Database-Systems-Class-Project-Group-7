CREATE or replace VIEW SHOW_INFO_MOVIE AS


SELECT
    ita.title Title,
    ita.region Region,
    ita.language Language,
    itb.startyear Year,
    itr.averagerating Rating,
    itr.numvotes Votes
FROM
    imdb_title_akas      ita,
    imdb_title_basics    itb,
    imdb_title_ratings   itr
WHERE
    1 = 1
    AND ita.titleid = itb.tconst
    AND itb.tconst = itr.tconst
    AND ita.titleid=itr.tconst
    AND itr.averagerating > 7
    AND itr.numvotes>1000; 

SELECT * FROM SHOW_INFO_MOVIE; --VIEW 1

CREATE VIEW SHOW_INFO_DIRECTED_NAMES AS 
select inb.primaryname Name from imdb_name_basics inb where inb.nconst IN(
SELECT
    s.directors
FROM
    samp               s,
    imdb_name_basics   inb
WHERE
    s.directors = inb.nconst
GROUP BY
    s.directors
HAVING
    COUNT(s.tconst) > 10) ;
    
    
SELECT * FROM  SHOW_INFO_DIRECTED_NAMES ; --VIEW 2

CREATE VIEW SHOW_TOP_TEN_TV_SERIES AS 
select title,seasonnumber,averagerating from (select ita.title,ite.seasonnumber,itr.averagerating from IMDB_TITLE_AKAS ita,
              imdb_title_episode ITE,
              imdb_title_ratings ITR
              where ita.titleid=ite.tconst
               and ite.tconst=itr.tconst
               and ite.seasonnumber>1
               order by itr.averagerating desc) where rownum<=10;
               
SELECT * FROM SHOW_TOP_TEN_TV_SERIES; --VIEW 3


CREATE VIEW SHOW_COUNT_PARTICULAR_RATING AS
SELECT
    itr.averagerating Rating,
    COUNT(ita.title) MoviesCount
FROM
    imdb_title_akas      ita,
    imdb_title_ratings   itr
WHERE
    ita.titleid = itr.tconst
GROUP BY
    itr.averagerating
ORDER BY itr.averagerating;

SELECT * FROM SHOW_COUNT_PARTICULAR_RATING; --view 4


CREATE VIEW SHOW_INFO_TV_EPISODES_NOT_NULL AS
SELECT
    ita.title,
    ita.types,
    itb.isadult,
    itb.startyear,
    ite.seasonnumber,
    ite.episodenumber,
    itr.numvotes

FROM
    imdb_title_akas      ita,
    imdb_title_basics    itb,
    imdb_title_episode   ite,
    imdb_title_ratings   itr
WHERE
    ita.titleid = itb.tconst
    and itb.tconst= ite.tconst
    and ita.titleid=itr.tconst
    and itb.tconst=itr.tconst
    and ite.tconst=itr.tconst
    and ite.episodenumber IS NOT NULL
order by title;

SELECT * FROM  SHOW_INFO_TV_EPISODES_NOT_NULL; --VIEW 5


CREATE VIEW SHOW_INFO_MOVIE_RUNTIMEMINUTES AS
SELECT
   ita.title,ita.types,itb.runtimeminutes
FROM
    imdb_title_akas ita,
    imdb_title_basics itb
WHERE
    (ita.titleid,ita.ordering) IN (
        SELECT
            titleid,ordering
        FROM
            imdb_title_akas
        WHERE
            lower(types)='original'
    )
    and ita.titleid=itb.tconst
    and itb.runtimeminutes=1
    order by itb.runtimeminutes;
    
SELECT * FROM SHOW_INFO_MOVIE_RUNTIMEMINUTES; --VIEW 6

CREATE VIEW SHOW_INFO_MOVIE_TITLE_DIRECTED AS
SELECT
    title
FROM
    (
        SELECT
            itc.tconst,
            ita.title
        FROM
            imdb_title_crew    itc,
            imdb_title_akas    ita,
            imdb_name_basics   inb
        WHERE
            itc.tconst = ita.titleid
            AND itc.directors = inb.nconst
            AND inb.primaryname = 'William K.L. Dickson'
        INTERSECT
        SELECT
            itr.tconst,
            ita.title
        FROM
            imdb_title_ratings   itr,
            imdb_title_akas      ita
        WHERE
            itr.tconst = ita.titleid
            AND itr.averagerating > 3
    );
SELECT * FROM SHOW_INFO_MOVIE_TITLE_DIRECTED;  --VIEW 7
