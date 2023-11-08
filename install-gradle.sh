apt update
apt install curl zip unzip -y && \
curl -s "https://get.sdkman.io" | bash && \
source "$HOME/.sdkman/bin/sdkman-init.sh" && \
sdk version && \
sdk install gradle