#!/bin/bash
kubectl apply -f ./app/service-account.yaml
kubectl apply -f ./app/app-nlb.yaml
kubectl apply -f ./app/app-svc.yaml
kubectl apply -f ./app/app-configmap.yaml
kubectl apply -f ./app/app-deployment.yaml
kubectl apply -f ./app/app-hpa.yaml

