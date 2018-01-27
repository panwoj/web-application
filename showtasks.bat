call runcrud.bat
if "%ERRORLEVEL%" == "0" goto browser
echo.
echo RUNCRUD has errors
goto fail

:browser
start chrome http://localhost:8080/crud/v1/task/getTasks
goto end

:fail
echo.
echo There were errors

:end
echo.
echo Opening browser