CREATE OR REPLACE VIEW samp as WITH
 model_param AS
    (
              SELECT tconst,
                        directors AS orig_str ,
                     ','
                            || directors
                            || ','                                 AS mod_str ,
                    1                                             AS start_pos ,
                   Length(directors)                                   AS end_pos ,
                    (Length(directors) - Length(Replace(directors, ','))) + 1 AS element_count ,
                    0                                             AS element_no ,
                    ROWNUM                                        AS rn
             FROM   imdb_title_crew )
      SELECT   tconst,
               trim(Substr(mod_str, start_pos, end_pos-start_pos)) directors
      FROM     (
                      SELECT *
                      FROM   model_param MODEL PARTITION BY (tconst, rn, orig_str, mod_str)
                      DIMENSION BY (element_no)
                      MEASURES (start_pos, end_pos, element_count)
                      RULES ITERATE (2000)
                      UNTIL (ITERATION_NUMBER+1 = element_count[0])
                      ( start_pos[ITERATION_NUMBER+1] = instr(cv(mod_str), ',', 1, cv(element_no)) + 1,
                      end_pos[iteration_number+1] = instr(cv(mod_str), ',', 1, cv(element_no) + 1) )
                  )
      WHERE    element_no != 0 
      ORDER BY tconst