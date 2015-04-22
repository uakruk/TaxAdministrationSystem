<?php


    session_id('uid');
    session_start();
    if(isset($_COOKIE[session_name()])) {
        setcookie(session_name(),'',time()-3600); # unset session id/cookies
    }
    session_destroy():
    session_commit();

?>