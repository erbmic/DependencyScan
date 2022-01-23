# Dockerfile for the dependency-scan frontend

# Customize public images
FROM node:14.13.1-alpine3.12 as builder
RUN npm install -g @angular/cli@10.1.6
EXPOSE 4200
WORKDIR /app

FROM trion/ng-cli-karma:10.1.5 as unittesting
WORKDIR /app
EXPOSE 4200
EXPOSE 9876

# Build frontend
FROM builder as builded
COPY . /app
RUN npm ci
RUN npm run build --prod

# Run unit tests
FROM unittesting as tested
COPY . /app
RUN npm ci
RUN ng test --watch false

# Create application container
FROM nginx:1.19.3-alpine as dependency-scan_frontend
EXPOSE 80
COPY --from=builded /app/dist/dependency-scan /usr/share/nginx/html
COPY conf.d /etc/nginx/conf.d
