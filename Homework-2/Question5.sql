select case 
    when regexp_count(HR.name.customername, ' ') = 1 then 
        lpad(regexp_substr(customername, '[^ ]+' ,1,1),2) 
        || regexp_replace((substr(regexp_substr(customername, '[^ ]+' ,1,1),3,length(regexp_substr(customername, '[^ ]+' ,1,1)))) ,'.','*' )
       || ' ' || 
       lpad(regexp_substr(customername, '[^ ]+' ,1,2),2) 
       || regexp_replace((substr(regexp_substr(customername, '[^ ]+' ,1,2),3,length(regexp_substr(customername, '[^ ]+' ,1,2)))) ,'.','*' )
       || ' ' 
    else lpad(regexp_substr(customername, '[^ ]+' ,1,1),2) 
        || regexp_replace((substr(regexp_substr(customername, '[^ ]+' ,1,1),3,length(regexp_substr(customername, '[^ ]+' ,1,1)))) ,'.','*' )
       || ' ' 
       || regexp_replace((substr(regexp_substr(customername, '[^ ]+' ,1,2),1,length(regexp_substr(customername, '[^ ]+' ,1,2)))) ,'.','*' )
       || ' ' ||
       lpad(regexp_substr(customername, '[^ ]+' ,1,3),2) 
       || regexp_replace((substr(regexp_substr(customername, '[^ ]+' ,1,3),3,length(regexp_substr(customername, '[^ ]+' ,1,3)))) ,'.','*' )
    end as customername from HR.name 
    