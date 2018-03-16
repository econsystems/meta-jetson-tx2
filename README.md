# meta-jetson-tx2

Yocto BSP layer for the nvidia jetson tx2 boards.

# NVIDIA jetson tx2 board

This is an AI supercomputer on a module, powered by NVIDIA Pascal™ architecture. Best of all, it packs this performance into a small, 
power-efficient form factor that’s ideal for intelligent edge devices like robots, drones, smart cameras, and portable medical devices. 
It supports all the features of the Jetson TX1 module while enabling bigger, more complex deep neural networks.
<https://www.nvidia.com/en-us/autonomous-machines/embedded-systems-dev-kits-modules/>.

# esomgears
eSOMgears is a cloud based Over-The-Air (OTA) firmware update tool that can update the firmware of your devices deployed in the field. 
It supports OTA firmware updates on both Linux and Android platforms. eSOMgears is available as a “SaaS – Software as a Service” option. 
Some of the advantages of eSOMgears are:

* Cloud based.
* Supports upgrade to any available new version.
* Supports downgrade to any available lower version.
* Avoids dead-brick during power failure.
* Rollback to any known version in case of an update failure.
* Supports Linux and Android platforms on respective boards.

## Quick links

* esomgears web frontend:  <https://esomgears.e-consystems.com>
* support e-mail: esomgears@e-consytems.com

## Description

This is the fail-safe hardware specific BSP overlay for the nvidia jetson tx2 device.

The meta-jetson-tx2 should work with Yocto distribution.

## Dependencies

This layer depends on:

* URI: git://git.yoctoproject.org/poky
  * branch: pyro
  * revision: HEAD

* URI: git://git.openembedded.org/meta-openembedded
  * layers: meta-oe, meta-multimedia, meta-networking, meta-python
  * branch: pyro
  * revision: HEAD

* URI: https://github.com/econsystems/meta-jetson-tx2
  * branch: master
  * revision: HEAD

* URI: https://github.com/meta-qt5/meta-qt5
  * branch: pyro
  * revision: HEAD

Download the layers after creating the product with esomgears from the web frontend.
* meta-product
* meta-example

# Update .template.conf file

 $vi poky/.templateconf
 #Template settings
 TEMPLATECONF=${TEMPLATECONF:-meta-jetson-tx2/conf}


## Quick Start

1. #source poky/oe-init-build-env jetson-tx2-build
2. Add meta-example layer to bblayers.conf and "esomgearexample" receipe to local.conf to enable esomgearexample package.
3. #bitbake core-image-sato
5. Download your development kit for your product from <https://esomgears.e-consystems.com>.
6. Run the firmware generator script.
7. Deploy generated sdcard image file to your SD card.
8. Flash the u-boot.
9. Boot your nvidia tx2 board.

## Maintainers

* esomgears team `<esomgears@e-consytems.com>`

