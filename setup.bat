@echo off
setlocal

set "base_path=src\main\java\com\vanderlelie\api\backend"

REM Create DAO and exceptions directories
mkdir %base_path%\dao
mkdir %base_path%\exception

REM Create DAO classes
for %%e in (CustomerDao UserOrderDao LogDao CustomerSettingDao PackagingTypeDao PackagingDao ProductTypeDao ProductDao SettingDao) do (
    type nul > %base_path%\dao\%%e.java
)

REM Create Exception classes
for %%e in (ResourceNotFoundException DataIntegrityViolationException BadRequestException UnauthorizedException AccessDeniedException) do (
    type nul > %base_path%\exception\%%e.java
)

echo DAO and Exception classes created successfully.
endlocal
