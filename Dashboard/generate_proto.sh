cd /Users/elvischidera/FluentStudio/BE/WorkServer/proto/
rm -r /Users/elvischidera/FluentStudio/FE/Dashboard/app/proto
mkdir /Users/elvischidera/FluentStudio/FE/Dashboard/app/proto
protoc -I=stats:tests:device:reports:work:server stats/*.proto tests/*.proto device/*.proto reports/*.proto work/*.proto server/*.proto \
--js_out=import_style=commonjs:/Users/elvischidera/FluentStudio/FE/Dashboard/app/proto \
--grpc-web_out=import_style=commonjs,mode=grpcwebtext:/Users/elvischidera/FluentStudio/FE/Dashboard/app/proto