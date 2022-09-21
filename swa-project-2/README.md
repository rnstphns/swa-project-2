Steps to load into minikube:

Make sure docker and minikube are running

in each module directory:

-kubectl apply –f <yamlfilename.yaml>
    Apply command for all yaml files in your directory in order: secrets -> config -> database -> service

-kubectl get deployments

-kubectl get pods
    Should see your pods running and pod ids

-minikube service <servicename> --url
    Prints a url to use postman

- pray minikube is stable
*******
Operation endpoints:
1. order-service endpoint 3306:30011/TCP 
2. customer endpoint 3306:30010/TCP
3. Payment endpoint 3306:30012/TCP 
4. we have 2 roles for customer: admin and user

Contrubuters:
Nora Chaynane, Antonyo Michael, Tsinat Mehari, Ryan Stephens


  


